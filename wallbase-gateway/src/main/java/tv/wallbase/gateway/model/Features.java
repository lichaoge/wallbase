package tv.wallbase.gateway.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 系统功能是否开启特性
 *
 * @author aboutdata.me
 */
public class Features implements Serializable {
    /**
     * 用户信息是否显示完整 实际情况是开发这模式需要开启此项 设置flase
     */
    @Setter
    @Getter
    private boolean dimPrivacy = true;  //默认值

    /**
     * 启用发送短信功能
     */
    @Setter
    @Getter
    private boolean enableSMS = false;  //默认值

    @Setter
    @Getter
    private boolean enableSearch = false;  //默认值

    /**
     * 是否启用用户注册和登录功能
     */
    @Setter
    @Getter
    private boolean enableLogin = false;  //默认值
}
