package tv.wallbase.test.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.StringUtils;
import tv.wallbase.gateway.enums.Category;
import tv.wallbase.gateway.enums.Purity;
import tv.wallbase.gateway.enums.WallpaperStatus;
import tv.wallbase.gateway.model.Wallpaper;
import tv.wallbase.gateway.service.SequenceService;
import tv.wallbase.gateway.service.WallpaperService;
import tv.wallbase.test.TestBase;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * Created by wangkun23 on 2017/9/21.
 */
public class oSSClientTest extends TestBase {

    final Logger logger = LoggerFactory.getLogger(getClass());


    @Resource
    OSSClient ossClient;


    @Resource
    private WallpaperService wallpaperService;


    @Resource
    private SequenceService sequenceService;


    //@Test
    public void get() throws IOException {

        File directory = new File("/Users/wangkun23/Pictures/刘念");

        if (directory.isDirectory()) {
            for (File photo : directory.listFiles()) {
                logger.info("{}", photo.getAbsolutePath());
                FileSystemResource fileSystemResource = new FileSystemResource(photo);

                String wallpaperNo = sequenceService.generateWallpaperNo();
                String filenameExtension = StringUtils.getFilenameExtension(fileSystemResource.getFilename());

                String fileId = "wallbase-" + wallpaperNo.concat(".") + filenameExtension;
                //ClassPathResource classPathResource = new ClassPathResource("static/images/m15.jpg");
                PutObjectResult putObjectRequest = ossClient.putObject("wallbasetv", fileId, fileSystemResource.getInputStream());

                //logger.info("{}", putObjectRequest.getResponse().isSuccessful());
                //if (putObjectRequest.getResponse().isSuccessful()) {
                Wallpaper entity = new Wallpaper();

                entity.setId(new Integer(wallpaperNo));
                entity.setCategory(Category.GENERAL);
                entity.setPurity(Purity.NSFW);
                entity.setViewsCount(0);
                entity.setFavoritesCount(0);
                entity.setSize(152d);
                entity.setImageUrl(fileId);
                entity.setThumbUrl(fileId);
                entity.setUserId(1);
                entity.setStatus(WallpaperStatus.UNASSIGNED);

                wallpaperService.save(entity);
                // }
            }
        }


    }
}
