package tv.wallbase.task;

import tv.wallbase.downloader.WallpaperDownloader;


/**
 * 多线程下载图片任务
 * Created by wangkun23 on 2017/10/6.
 */
public class DownloadThread implements Runnable {
    private WallpaperDownloader downloader;
    private Integer wallpaperId;

    public DownloadThread(final WallpaperDownloader downloader, final Integer wallpaperId) {
        this.downloader = downloader;
        this.wallpaperId = wallpaperId;
    }

    @Override
    public void run() {
        this.downloader.download(this.wallpaperId);
    }
}
