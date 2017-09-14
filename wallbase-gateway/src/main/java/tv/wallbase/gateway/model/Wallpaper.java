package tv.wallbase.gateway.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.ToString;
import tv.wallbase.gateway.enums.Category;
import tv.wallbase.gateway.enums.Purity;
import tv.wallbase.gateway.enums.WallpaperStatus;
import tv.wallbase.gateway.model.*;

/**
 * 图片数据库
 * Created by wangkun23 on 2017/7/28.
 */
@ToString
public class Wallpaper implements Serializable {
    @Setter
    @Getter
    private Integer id;

    @Setter
    @Getter
   /*标题 现在是wallhaven 的id*/
    private String title;

    @Setter
    @Getter
    private Purity purity;

    @Setter
    @Getter
    private Double size;

    @Setter
    @Getter
    private Integer viewsCount;

    @Setter
    @Getter
    private Integer favoritesCount;

    @Setter
    @Getter
   /*缩略图ULR*/
    private String thumbUrl;

    @Setter
    @Getter
    /*原图URL*/
    private String imageUrl;

    @Setter
    @Getter
    /*上传者的用户ID*/
    private Integer userId;

    @Setter
    @Getter
    private WallpaperStatus status;

    @Setter
    @Getter
    private Date createDate;

    @Setter
    @Getter
    private Date updateDate;

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
