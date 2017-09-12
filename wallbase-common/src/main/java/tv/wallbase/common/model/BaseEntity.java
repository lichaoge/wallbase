package tv.wallbase.common.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
/**
 * Entity - 基类
 */
public abstract class BaseEntity implements Serializable {

    @Setter
    @Getter
    private String id;

    @Setter
    @Getter
    // 创建日期
    private Date createTime;

     @Setter
     @Getter
     //修改日期
    private Date updateTime;
}
