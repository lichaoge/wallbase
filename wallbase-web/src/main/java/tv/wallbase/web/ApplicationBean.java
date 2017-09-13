package tv.wallbase.web;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tv.wallbase.settings.FeaturesSettings;
import tv.wallbase.settings.SystemSettings;

/**
 * 全局配置信息
 *
 * @author youyou
 */
@Component("appBean")
public class ApplicationBean {

    @Autowired
    private SystemSettings systemConfig;

    @Getter
    private String siteUrl;

    @Getter
    private String assetsUrl;

    @Getter
    private boolean developMode;

    @Setter
    @Getter
    //设置前端node grunt package的版本号
    private String gruntVersion;

    //@Resource
    //private MemberService memberService;

    //@Resource
    //private ConfigService configService;

//    public Member getCurrentUser() {
//        return memberService.getCurrent();
//    }

    /**
     * 配置新开发功能是否可用线上
     *
     * @return
     */
    public FeaturesSettings getFeatures() {
        return systemConfig.getFeatures();
    }

    public SystemSettings getSystemConfig() {
        return systemConfig;
    }

    /**
     * 主站路径 http://lockbur.com 默认
     *
     * @return
     */
    public String getSiteUrl() {
        return systemConfig.getSiteUrl();
    }

    /**
     * css js 资源服务器
     *
     * @return
     */
    public String getAssetsUrl() {
        return systemConfig.getAssetsUrl();
    }

    /**
     * 是否是开发者模式
     *
     * @return
     */
    public boolean isDevelopMode() {
        return systemConfig.isDevelopMode();
    }


}
