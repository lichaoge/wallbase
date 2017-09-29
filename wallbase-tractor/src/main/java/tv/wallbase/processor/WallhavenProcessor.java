package tv.wallbase.processor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tv.wallbase.gateway.enums.Category;
import tv.wallbase.gateway.enums.CollectorType;
import tv.wallbase.gateway.enums.Purity;
import tv.wallbase.gateway.model.Tag;
import tv.wallbase.gateway.model.Wallpaper;
import tv.wallbase.gateway.service.CollectorService;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 规则 先解析分页页面 ，然后根据分页页面的URL 去抓去wallpaper 的详情页面，然后把需要的数据解析出来
 * Created by wangkun23 on 2017/9/29.
 */
@Component
public class WallhavenProcessor implements PageProcessor {

    final Logger logger = LoggerFactory.getLogger(WallhavenProcessor.class);

    private static final String PAGE_URL = "^https\\://alpha\\.wallhaven\\.cc/latest\\?page";
    private static final String WALLPAPER_URL = "^https\\://alpha\\.wallhaven\\.cc/wallpaper/";

    @Resource
    CollectorService collectorService;

    @Override
    public void process(Page page) {

        //如果分页 就把页面加入详情页面继续抓去
        if (page.getUrl().regex(PAGE_URL).match()) {
            logger.info("page url {} ", page.getUrl());
            List<Selectable> figureElements = page.getHtml().xpath("//section/ul/li").nodes();
            for (Selectable figure : figureElements) {
                //logger.info("##{} ", figure);
                String wallpaperId = figure.xpath("//figure/@data-wallpaper-id").get();
                //需要判断是否有该ID 如果有则不抓取 TODO..
                if (!collectorService.exist(CollectorType.WALLHAVEN, wallpaperId)) {
                    page.addTargetRequest(new Request("https://alpha.wallhaven.cc/wallpaper/" + wallpaperId).putExtra("wallpaperId", wallpaperId));
                } else {
                    logger.info("wallpaperId exist {} ", wallpaperId);
                }
            }
        }

        //如果是详情 解析页面数据、
        //https://alpha.wallhaven.cc/wallpaper/51351
        if (page.getUrl().regex(WALLPAPER_URL).match()) {
            Wallpaper wallpaper = new Wallpaper();

            String wallpaperId = (String) page.getRequest().getExtra("wallpaperId");

            wallpaper.setTitle(wallpaperId);
            //1 原图地址
            //wallpapers.wallhaven.cc/wallpapers/full/wallhaven-80626.jpg
            String imageUrl = page.getHtml().xpath("//section[@id='showcase']/div/img[@id='wallpaper']/@src").get();
            wallpaper.setImageUrl(imageUrl);

            //2 类别
            List<Selectable> dl = page.getHtml().xpath("//div/[@data-storage-id='showcase-info']/dl/dd/text()").nodes();
            if (dl.size() != 0) {
                String categoryName = dl.get(1).get();
                Category category = StringUtils.equalsIgnoreCase(categoryName, "GENERAL") ? Category.GENERAL
                        : StringUtils.equalsIgnoreCase(categoryName, "ANIME") ? Category.ANIME
                        : StringUtils.equalsIgnoreCase(categoryName, "PEOPLE") ? Category.PEOPLE
                        : null;
                logger.info("category {} ", category);
                wallpaper.setCategory(category);
            }

            //3 标签信息
            List<Selectable> tagLiElements = page.getHtml().xpath("//ul[@id='tags']/li").nodes();
            List<Tag> tags = new ArrayList<>(tagLiElements.size());
            for (Selectable li : tagLiElements) {
                String tagId = li.xpath("//li/@data-tag-id").get();
                String tagName = li.xpath("//li/a[@class='tagname']/text()").get();

                //region purity
                //String liClassString = li.xpath("//li/@class").get();
//                Purity purity = liClassString.contains("tag-sfw") ? Purity.SFW
//                        : liClassString.contains("tag-sketchy") ? Purity.SKETCHY
//                        : liClassString.contains("tag-nsfw") ? Purity.NSFW
//                        : null;
//                if (purity == null) {
//                    throw new IllegalArgumentException("Could not parse purity of wallpaper thumbnail");
//                }
                logger.info("tagId {} ", tagId);
                logger.info("tagName {} ", tagName);

                Tag tag = new Tag();
                tag.setId(Integer.valueOf(tagId));
                tag.setName(tagName);
                //tag.setPurity(purity);

                tags.add(tag);
            }
            wallpaper.setTags(tags);


            //4 纯净度
            String purityString = page.getHtml().xpath("//form[@id='wallpaper-purity-form']/label/text()").get();
            Purity purity = purityString.contains("SFW") ? Purity.SFW
                    : purityString.contains("SKETCHY") ? Purity.SKETCHY
                    : purityString.contains("NSFW") ? Purity.NSFW
                    : null;
            if (purity == null) {
                throw new IllegalArgumentException("Could not parse purity of wallpaper");
            }
            wallpaper.setPurity(purity);

            //默认创建用户
            wallpaper.setUserId(1);

            //放到pipeline中处理
            page.putField("wallpaperId", wallpaperId);
            page.putField("wallpaperUrl", page.getUrl().toString());
            page.putField("wallpaper", wallpaper);
        }

    }

    @Override
    public Site getSite() {
        Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
        return site;
    }

    public static void main(String[] args) {
        //Spider.create(new WallpaperProcessor()).addUrl("https://alpha.wallhaven.cc/random?page=2").run();
        Spider.create(new WallhavenProcessor()).addRequest(new Request("https://alpha.wallhaven.cc/wallpaper/51351").putExtra("wallpaperId", "51351")).run();
    }
}
