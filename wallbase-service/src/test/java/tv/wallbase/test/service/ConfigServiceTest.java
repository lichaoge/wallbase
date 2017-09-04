package tv.wallbase.test.service;

import tv.wallbase.common.system.SystemConfig;
import tv.wallbase.gateway.service.ConfigService;
import tv.wallbase.test.TestBase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/10/21.
 */
public class ConfigServiceTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(ConfigServiceTest.class);

    @Resource
    private ConfigService configService;

    @Test
    public void get() {
        String config = configService.get();
        logger.info("config {}", config);
    }

    @Test
    public void getSystemConfig() {
        SystemConfig config = configService.getSystemConfig();
        logger.info("config ###");
        logger.info("config {}", config);
    }

}
