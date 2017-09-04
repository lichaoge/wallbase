package tv.wallbase.tractor.config;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.ui.velocity.VelocityEngineFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by wangkun23 on 2017/9/4.
 */
@Configuration
public class WebConfig {

//    @Bean
//    public VelocityEngine velocityEngine() throws VelocityException, IOException {
//        VelocityEngineFactory velocityEngineFactory = new VelocityEngineFactory();
//        Properties props = new Properties();
//        props.put("resource.loader", "class");
//        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
//
//        velocityEngineFactory.setVelocityProperties(props);
//        return velocityEngineFactory.createVelocityEngine();
//    }
}
