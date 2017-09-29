package tv.wallbase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * web项目启动类
 * Created by wangkun23 on 2017/9/5.
 */
@SpringBootApplication
public class TractorApplication {

    static final Logger logger = LoggerFactory.getLogger(TractorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TractorApplication.class, args);
    }
}
