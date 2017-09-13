package tv.wallbase.settings;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * 系统功能是否开启特性
 *
 * @author youyou
 */
@ToString
@Configuration
@ConfigurationProperties(prefix = "app.config.switch")
public class FeaturesSettings implements Serializable {

    /**
     * 用户信息是否显示完整 实际情况是开发这模式需要开启此项 设置flase
     */
    @Setter
    @Getter
    private boolean dimPrivacy = true;  //默认值

}
