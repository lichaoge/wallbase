package tv.wallbase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 多线程处理
 * Created by wangkun23 on 2017/9/29.
 */
@Configuration
@EnableScheduling
public class TaskConfig {
    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(10);
        threadPool.setMaxPoolSize(50);
        threadPool.setQueueCapacity(2000);
        threadPool.setKeepAliveSeconds(60);
        return threadPool;
    }
}
