package tv.wallbase.downloader;

import com.aliyun.oss.OSSClient;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tv.wallbase.gateway.enums.WallpaperStatus;
import tv.wallbase.gateway.model.Wallpaper;
import tv.wallbase.gateway.service.WallpaperService;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * 图片下载并上传到阿里云
 * Created by wangkun23 on 2017/9/29.
 */
@Component
public class WallpaperDownloader {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    OSSClient ossClient;

    @Resource
    WallpaperService wallpaperService;

    /**
     * 下载图片并上传到阿里云
     *
     * @throws IOException
     */
    @Transactional
    public void download(Integer wallpaperId) {
        logger.info("download wallpaperId {}", wallpaperId);
        Wallpaper wallpaper = wallpaperService.findDetails(wallpaperId);
        if (wallpaper == null) {
            throw new IllegalArgumentException("wallpaperId " + wallpaperId + " not exist ");
        }

        /**
         * //wallpapers.wallhaven.cc/wallpapers/full/wallhaven-569415.jpg
         * https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-569415.jpg
         ***/
        String url = "https:".concat(wallpaper.getImageUrl());
        String filename = StringUtils.getFilename(url);
        try {
            Connection.Response response = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .maxBodySize(0)//默认是1024 * 1024 =1M
                    .timeout(600000)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.95 Safari/537.36")
                    .execute();

            if (response.statusCode() == 200) {
                String filenameExtension = StringUtils.getFilenameExtension(filename);
                String fileId = "wallbase-" + wallpaperId.toString().concat(".") + filenameExtension;
                //上传到阿里云
                ossClient.putObject("wallbasetv", fileId, new ByteArrayInputStream(response.bodyAsBytes()));

                Wallpaper update = new Wallpaper();
                update.setId(wallpaperId);
                update.setThumbUrl(fileId);
                update.setStatus(WallpaperStatus.ASSIGNED);

                logger.info("upload fileId {}", fileId);
                wallpaperService.update(update);
            } else {
                logger.info("error {}", response.statusCode());
            }
        } catch (IOException e) {
            logger.info("error {}", wallpaperId);
        }
    }
}
