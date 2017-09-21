package tv.wallbase.config;

import com.aliyun.oss.OSSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

/**
 * 阿里云客户端配置
 * Created by wangkun23 on 2017/9/21.
 */
@Configuration
public class OssClientConfig {

    final Logger logger = LoggerFactory.getLogger(getClass());

    String endpoint = "http://oss-cn-beijing.aliyuncs.com";

    @Value("${aliyun.oss.accessKeyId}")
    String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    String accessKeySecret;


    private OSSClient ossClient;

    @Bean
    public OSSClient oSSClient() {
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        return ossClient;
    }

    @PreDestroy
    public void destory() {
        logger.info("oss client shutdown.");
        ossClient.shutdown();
    }
}
