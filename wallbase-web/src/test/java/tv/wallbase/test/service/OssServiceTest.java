package tv.wallbase.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tv.wallbase.common.rest.Page;
import tv.wallbase.common.rest.Pageable;
import tv.wallbase.gateway.model.Wallpaper;
import tv.wallbase.gateway.service.OssService;
import tv.wallbase.gateway.service.WallpaperService;

import javax.annotation.Resource;

/**
 * Created by wangkun23 on 2017/9/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OssServiceTest {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    OssService ossService;

    @Resource
    WallpaperService wallpaperService;

    //@Test
    public void updateWallpaperMetadataInfo() {
        Pageable pageable = new Pageable(1, 1000);
        Page<Wallpaper> page = wallpaperService.findByPage(pageable);

        for (Wallpaper wallpaper : page.getContent()) {
            ossService.updateWallpaperMetadataInfo(wallpaper);
        }
    }


}
