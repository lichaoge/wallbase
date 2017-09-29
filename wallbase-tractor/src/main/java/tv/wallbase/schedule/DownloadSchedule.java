package tv.wallbase.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by wangkun23 on 2017/9/29.
 */
@Component
public class DownloadSchedule {

    @Resource
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Scheduled(cron = "0/5 * * * * ?")
    public void downloadTask() {
        if (threadPoolTaskExecutor.getActiveCount() < 50) {
            threadPoolTaskExecutor.submit(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    }
}
