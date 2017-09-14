package tv.wallbase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * web项目启动类
 * Created by wangkun23 on 2017/9/5.
 */
@SpringBootApplication
public class WebApplication {

    static final Logger logger = LoggerFactory.getLogger(WebApplication.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WebApplication.class, args);

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            logger.info("bean {}", beanName);
        }
    }
}
