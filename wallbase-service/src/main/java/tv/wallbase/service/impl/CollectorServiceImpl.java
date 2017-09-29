package tv.wallbase.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tv.wallbase.gateway.enums.CollectorType;
import tv.wallbase.gateway.enums.WallpaperStatus;
import tv.wallbase.gateway.model.Collector;
import tv.wallbase.gateway.model.Wallpaper;
import tv.wallbase.gateway.service.CollectorService;
import tv.wallbase.gateway.service.WallpaperService;
import tv.wallbase.mapper.CollectorMapper;

import javax.annotation.Resource;

/**
 * 图片采集代码
 * Created by wangkun23 on 2017/9/29.
 */
@Service
public class CollectorServiceImpl implements CollectorService {

    @Resource
    private CollectorMapper collectorMapper;

    @Resource
    WallpaperService wallpaperService;

    @Override
    @Transactional
    public void save(Collector entity, Wallpaper wallpaper) {
        entity.setStatus(WallpaperStatus.UNASSIGNED.name());
        collectorMapper.insert(entity);

        //存储图片信息
        wallpaperService.save(wallpaper);
    }

    /**
     * 判断是否存在
     *
     * @param site
     * @param name
     * @return
     */
    @Override
    public Boolean exist(CollectorType site, String name) {
        return collectorMapper.findBySiteAndName(site, name) != null;
    }
}
