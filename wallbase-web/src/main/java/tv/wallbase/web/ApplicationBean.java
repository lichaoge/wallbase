package tv.wallbase.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import tv.wallbase.settings.FeaturesSettings;
import tv.wallbase.settings.SystemSettings;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;


/**
 * 全局配置信息
 *
 * @author youyou
 */
@Component
public class ApplicationBean {

    final Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    //配置新开发功能是否可用线上
    private SystemSettings systemSettings;

    //主站路径 http://lockbur.com 默认
    @Getter
    private String siteUrl;

    //css js 资源服务器
    @Getter
    private String assetsUrl;

    @Getter
    private boolean developMode;

    @Getter
    //设置前端node grunt package的版本号
    private String gruntVersion;


    //@Resource
    //private MemberService memberService;


    @PostConstruct
    public void initialize() {
        this.siteUrl = systemSettings.getSiteUrl();
        this.assetsUrl = systemSettings.getAssetsUrl();
        this.developMode = systemSettings.isDevelopMode();

        //设置version 从grunt打包到生产使用
        ClassPathResource classPathResource = new ClassPathResource("package.json");
        try (InputStream is = classPathResource.getInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            String version = mapper.readTree(is).path("version").asText();
            this.gruntVersion = version;
            logger.info("package.json version is {}", version);
        } catch (IOException ex) {
            //生产环境 打包部署需要
            logger.error("package.json is not exist {}", ex);
        }
    }

//    public Member getCurrentUser() {
//        return memberService.getCurrent();
//    }

    /**
     * 是否是开发者模式
     *
     * @return
     */
    public boolean getDevelopMode() {
        return systemSettings.isDevelopMode();
    }


}
