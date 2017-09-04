package tv.wallbase.test;

import tv.wallbase.gateway.service.EmailService;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by wangkun23 on 2017/2/10.
 */
public class SendMailTest extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(SendMailTest.class);

    @Resource
    private EmailService emailService;


    @Test
    public void sendEmail() throws Exception {
        emailService.send("845885222@qq.com", "测试", "user_register_mail.vm", new HashedMap());
        LOGGER.info("########## {}");
    }
}
