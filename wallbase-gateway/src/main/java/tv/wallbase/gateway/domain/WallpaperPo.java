package tv.wallbase.gateway.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import tv.wallbase.gateway.enums.Purity;

/**
 * 图片数据库
 * Created by wangkun23 on 2017/7/28.
 */
public class WallpaperPo implements Serializable {
    @Setter
    @Getter
    private Integer id;

    @Setter
    @Getter
    private Integer categoryId;

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
    private Integer status;

    @Setter
    @Getter
    private Date createDate;

    @Setter
    @Getter
    private Date updateDate;
}
