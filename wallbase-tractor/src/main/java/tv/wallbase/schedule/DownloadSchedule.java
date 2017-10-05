package tv.wallbase.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import tv.wallbase.common.rest.Page;
import tv.wallbase.common.rest.Pageable;
import tv.wallbase.downloader.WallpaperDownloader;
import tv.wallbase.gateway.enums.WallpaperStatus;
import tv.wallbase.gateway.model.Wallpaper;
import tv.wallbase.gateway.service.WallpaperService;

import javax.annotation.Resource;

/**
 * Created by wangkun23 on 2017/9/29.
 */
@Component
public class DownloadSchedule {

    final Logger logger = LoggerFactory.getLogger(getClass());

    private Integer page = 1;

    @Resource
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Resource
    WallpaperDownloader downloader;

    @Resource
    WallpaperService wallpaperService;

    @Scheduled(cron = "0/5 * * * * ?")
    public void downloadTask() {
        if (threadPoolTaskExecutor.getActiveCount() < 50) {
            Pageable pageable = new Pageable(page, 24);
            pageable.setSearchProperty("status");
            pageable.setSearchValue(WallpaperStatus.ASSIGNED.name());
            Page<Wallpaper> pages = wallpaperService.findByPage(pageable);

            logger.info("pages {}", pages.getContent().size());

            for (Wallpaper wallpaper : pages.getContent()) {
                threadPoolTaskExecutor.submit(new Runnable() {
                    @Override
                    public void run() {
                        downloader.download(wallpaper.getId());
                    }
                });
            }
            page++;
        }
    }
}
