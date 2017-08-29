package tv.wallbase.gateway.model;

import tv.wallbase.gateway.domain.WallpaperPo;
import tv.wallbase.gateway.enums.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 图片信息
 */
@ToString
public class Wallpaper extends WallpaperPo {

    @Setter
    @Getter
    private Resolution resolution;

    @Setter
    @Getter
    private List<Color> colors;

    @Setter
    @Getter
    private List<Tag> tags;

    @Setter
    @Getter
    private User user;

    @Setter
    @Getter
    private Category category;

    @Setter
    @Getter
    private List<WallpaperCollection> collections;

}
