package tv.wallbase.downloader;

import com.aliyun.oss.OSSClient;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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

    /**
     * 下载图片并上传到阿里云
     *
     * @param url
     * @throws IOException
     */
    public String download(String url, String wallpaperId) throws IOException {
        String filename = StringUtils.getFilename(url);
        Connection.Response response = Jsoup.connect(url)
                .ignoreContentType(true)
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.95 Safari/537.36")
                .execute();
        if (response.statusCode() == 200) {
            String filenameExtension = StringUtils.getFilenameExtension(filename);
            String fileId = "wallbase-" + wallpaperId.concat(".") + filenameExtension;
            //上传到阿里云
            ossClient.putObject("wallbasetv", fileId, new ByteArrayInputStream(response.bodyAsBytes()));
            return fileId;
        } else {
            logger.info("error {}", response.statusCode());
            return null;
        }
    }
}
