package tv.wallbase.test.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import tv.wallbase.test.TestBase;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by wangkun23 on 2017/9/21.
 */
public class oSSClientTest extends TestBase {

    final Logger logger = LoggerFactory.getLogger(getClass());


    @Resource
    OSSClient ossClient;

    @Test
    public void get() throws IOException {

        ClassPathResource classPathResource = new ClassPathResource("static/images/m15.jpg");
        PutObjectResult result = ossClient.putObject("wallbasetv", "082.jpeg", classPathResource.getInputStream());

        logger.info("{}", result);
    }
}
