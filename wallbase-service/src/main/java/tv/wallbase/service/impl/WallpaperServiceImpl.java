package tv.wallbase.service.impl;

import tv.wallbase.common.rest.Page;
import tv.wallbase.common.rest.Pageable;
import tv.wallbase.gateway.model.Wallpaper;
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
        Wallpaper wallpaper = wallpaperMapper.findById(id);
        return null;
    }
}
