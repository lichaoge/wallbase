package tv.wallbase.gateway.service;

import tv.wallbase.gateway.model.Wallpaper;

import java.io.IOException;

/**
 * 阿里云对象存储
 * Created by wangkun23 on 2017/9/24.
 */
public interface OssService {

    /**
     * 更新图片的元数据
     *
     * @param wallpaper
     */
    public void updateWallpaperMetadataInfo(Wallpaper wallpaper);
}
