package tv.wallbase.test.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tv.wallbase.gateway.service.SequenceService;

import javax.annotation.Resource;

/**
 * Created by wangkun23 on 2017/9/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SequenceServiceTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private SequenceService sequenceService;


    //@Test
    public void generateWallpaperNo() {
        String wallpaperNo = sequenceService.generateWallpaperNo();
        logger.info("{}", wallpaperNo);
    }
}
