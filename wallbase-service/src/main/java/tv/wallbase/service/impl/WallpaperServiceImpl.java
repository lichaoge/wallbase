package tv.wallbase.service.impl;

import org.springframework.transaction.annotation.Transactional;
import tv.wallbase.common.rest.Page;
import tv.wallbase.common.rest.Pageable;
import tv.wallbase.gateway.enums.WallpaperStatus;
import tv.wallbase.gateway.model.Tag;
import tv.wallbase.gateway.model.Wallpaper;
import tv.wallbase.gateway.service.SequenceService;
import tv.wallbase.gateway.service.WallpaperService;
import tv.wallbase.mapper.WallpaperMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 壁纸管理
 * Created by wangkun23 on 2017/7/30.
 */
@Service
public class WallpaperServiceImpl implements WallpaperService {

    @Resource
    WallpaperMapper wallpaperMapper;

    @Resource
    private SequenceService sequenceService;

    /**
     * 保存
     *
     * @param wallpaper
     */
    @Override
    @Transactional
    public void save(Wallpaper wallpaper) {
        String wallpaperNo = sequenceService.generateWallpaperNo();
        //处理该图片TAG信息
        List<Tag> tags = wallpaper.getTags();
        //TODO 先判断TAG是否存在
        //在关联wallpaper和tag关系

        wallpaper.setId(new Integer(wallpaperNo));
        wallpaper.setViewsCount(0);
        wallpaper.setFavoritesCount(0);
        wallpaper.setStatus(WallpaperStatus.UNASSIGNED);

        wallpaperMapper.insert(wallpaper);
    }

    /**
     * 修改
     *
     * @param wallpaper
     */
    @Override
    public void update(Wallpaper wallpaper) {
        wallpaperMapper.update(wallpaper);
    }

    /**
     * 分页查询
     *
     * @param pageable
     * @return
     */
    @Override
    public Page<Wallpaper> findByPage(Pageable pageable) {
        List<Wallpaper> list = wallpaperMapper.findByPage(pageable);
        Long count = wallpaperMapper.countByPage(pageable);
        return new Page<>(list, count, pageable);
    }


    @Override
    public Wallpaper findDetails(Integer id) {
        return wallpaperMapper.findById(id);
    }
}
