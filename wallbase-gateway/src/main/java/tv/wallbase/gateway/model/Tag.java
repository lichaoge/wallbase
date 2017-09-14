package tv.wallbase.gateway.model;

import tv.wallbase.gateway.enums.Purity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 标签
 */
@ToString
public class Tag implements Serializable {

    @Setter
    @Getter
    private Integer id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private Purity purity;

    @Setter
    @Getter
    private TagCategory category;

    @Setter
    @Getter
    private Set<String> aliases;

    @Setter
    @Getter
    private Long taggedWallpapersCount;

    @Setter
    @Getter
    private Long taggedWallpapersViewCount;

    @Setter
    @Getter
    private Long subscribersCount;

    @Setter
    @Getter
    private Integer status;

    @Setter
    @Getter
    /*上传者的用户ID*/
    private Integer userId;

    @Setter
    @Getter
    private Date createDate;

    @Setter
    @Getter
    private Date updateDate;


    /**
     * 创建用户
     */
    @Setter
    @Getter
    private User user;
}
