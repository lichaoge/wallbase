package tv.wallbase.gateway.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/10/24.
 */

@ToString
public class AdminRoleEntity implements Serializable {


    @Setter
    @Getter
    private long adminId;


    @Setter
    @Getter
    private long roleId;

    @Setter
    @Getter
    private long creatorId;//创建人


    @Setter
    @Getter
    private Date createdTime;

    @Setter
    @Getter
    private Date modifiedTime;
}
