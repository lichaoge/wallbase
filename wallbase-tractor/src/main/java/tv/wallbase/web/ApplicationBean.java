package tv.wallbase.web;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tv.wallbase.settings.SystemSettings;

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

    /**
     * 是否是开发者模式
     *
     * @return
     */
    public boolean getDevelopMode() {
        return systemSettings.isDevelopMode();
    }

}
