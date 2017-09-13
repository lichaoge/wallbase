package tv.wallbase.settings;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * @ 系统配置信息
 * @author aboutdata.me
 */
@ToString
@Configuration
@ConfigurationProperties(prefix = "tv.config")
public class SystemSettings implements Serializable {

    /**
     * *
     * 是否是开发者模式
     */
    @Getter
    @Setter
    @Value("${develop.mode}")
    private boolean developMode = false;

    //后台用户开户默认密码，如果为null表示使用手机短信发送随机密码
    @Getter
    @Setter
    @Value("${default.password}")
    private String defaultPassword = "123456";

    @Getter
    @Setter
    @Value("${site.url}")
    private String siteUrl = "http://localhost:8080";

    //静态资源服务器(css js 等)
    @Getter
    @Setter
    @Value("${assets.url}")
    private String assetsUrl = "http://assets.lockbur.com";

    @Getter
    @Setter
    @Value("${solr.server.url}")
    private String solrServer = "http://localhost:9090/solr";

    @Getter
    @Setter
    @Value("${storage.host}")
    private String defaultStorageHost = "http://imgs1.lockbur.com";

    /**
     * 各平台通用功能
     */
    @Getter
    @Setter
    @Autowired
    private FeaturesSettings features;

}
