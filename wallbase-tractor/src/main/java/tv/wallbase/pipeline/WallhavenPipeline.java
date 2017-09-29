package tv.wallbase.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tv.wallbase.gateway.enums.CollectorType;
import tv.wallbase.gateway.model.Collector;
import tv.wallbase.gateway.model.Wallpaper;
import tv.wallbase.gateway.service.CollectorService;
import tv.wallbase.gateway.service.WallpaperService;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;

/**
 * 处理wallhaven的抓去结果
 * Created by wangkun23 on 2017/9/29.
 */
@Component
public class WallhavenPipeline implements Pipeline {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    CollectorService collectorService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        String wallpaperId = resultItems.get("wallpaperId");
        String wallpaperUrl = resultItems.get("wallpaperUrl");
        Wallpaper wallpaper = resultItems.get("wallpaper");

        if (wallpaper != null) {
            //把该记录放到collector表中
            Collector collector = new Collector(CollectorType.WALLHAVEN, wallpaperId, wallpaperUrl);
            collectorService.save(collector, wallpaper);
        }
    }
}
