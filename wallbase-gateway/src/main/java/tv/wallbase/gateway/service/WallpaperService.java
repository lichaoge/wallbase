package tv.wallbase.gateway.service;

import tv.wallbase.common.rest.Page;
import tv.wallbase.common.rest.Pageable;
import tv.wallbase.gateway.model.Wallpaper;

/**
 * 壁纸管理
 * Created by wangkun23 on 2017/7/30.
 */
public interface WallpaperService {

    /**
     * 保存
     *
     * @param wallpaper
     */
    void save(Wallpaper wallpaper);

    /**
     * 修改
     *
     * @param wallpaper
     */
    void update(Wallpaper wallpaper);

    /**
     * 分页查询
     *
     * @return
     */
    public Page<Wallpaper> findByPage(Pageable pageable);


    /***
     * 详情页面
     * @param id
     * @return
     */
    public Wallpaper findDetails(Integer id);
}
