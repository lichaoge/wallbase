package tv.wallbase.test.generator.mapper;

import tv.wallbase.test.generator.model.Wallpaper;

public interface WallpaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wallpaper record);

    int insertSelective(Wallpaper record);

    Wallpaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wallpaper record);

    int updateByPrimaryKey(Wallpaper record);
}