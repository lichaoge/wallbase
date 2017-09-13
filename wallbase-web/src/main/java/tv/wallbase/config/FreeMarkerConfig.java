package tv.wallbase.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.HashMap;
import java.util.Map;

/**
 * freemarker 配置
 *
 * @link https://stackoverflow.com/questions/34988679/how-to-access-spring-boot-properties-from-freemarker-template?rq=1
 * <p>
 * Created by wangkun23 on 2017/9/13.
 */
@Configuration
public class FreeMarkerConfig extends FreeMarkerAutoConfiguration.FreeMarkerWebConfiguration {

//    @Bean(name = "freemarkerConfig")
//    public FreeMarkerConfigurer getFreemarkerConfig() {
//        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//        //configurer.setTemplateLoaderPath("**classpath:mail**/");
//        Map<String, Object> map = new HashMap<>();
//
//        //map.put("xml_escape", new XmlEscape());
//        configurer.setFreemarkerVariables(map);
//        return configurer;
//    }

    @Value("${version}")
    private String version;

    /**
     * spring freemarker 默认配置
     *
     * @return
     */
    @Override
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = super.freeMarkerConfigurer();

        Map<String, Object> sharedVariables = new HashMap<>();
        sharedVariables.put("version", version);
        configurer.setFreemarkerVariables(sharedVariables);

        return configurer;
    }
}
