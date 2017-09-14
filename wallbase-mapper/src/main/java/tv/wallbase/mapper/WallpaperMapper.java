package tv.wallbase.mapper;

import org.apache.ibatis.annotations.Mapper;
import tv.wallbase.common.rest.Pageable;
import tv.wallbase.gateway.model.Wallpaper;

import java.util.List;

/**
 * 壁纸管理
 */
@Mapper
public interface WallpaperMapper {

    /**
     * 插入新壁纸信息
     *
     * @param record
     * @return
     */
    int insert(Wallpaper record);

    Wallpaper findById(Integer id);

    int update(Wallpaper record);

    /**
     * 分页查询列表
     *
     * @param pageable
     * @return
     */
    public List<Wallpaper> findByPage(Pageable pageable);

    /**
     * *
     * 分页查询 count
     *
     * @param pageable
     * @return
     */
    public Long countByPage(Pageable pageable);
}