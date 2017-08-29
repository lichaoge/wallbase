package tv.wallbase.gateway.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/10/22.
 */
@ToString
public class AdminEntity implements Serializable {


    @Setter
    @Getter
    private long id;

    @Setter
    @Getter
    private String username;// 用户名

    @Setter
    @Getter
    private String password;// 密码

    @Setter
    @Getter
    private String email;// E-mail

    @Setter
    @Getter
    private String name;// 姓名

    @Setter
    @Getter
    private String department;// 部门

    @Setter
    @Getter
    private Boolean accountEnabled;// 账号是否启用

    @Setter
    @Getter
    private Boolean accountLocked;// 账号是否锁定

    @Setter
    @Getter
    private Boolean accountExpired;// 账号是否过期

    @Setter
    @Getter
    private Boolean credentialsExpired;// 凭证是否过期

    @Setter
    @Getter
    private Integer loginFailureCount;// 连续登录失败的次数


    @Setter
    @Getter
    private Date lockedDate;// 账号锁定日期

    @Setter
    @Getter
    private Date loginDate;// 最后登录日期

    @Setter
    @Getter
    private String loginIp;// 最后登录IP

    @Setter
    @Getter
    private Date createdTime;

    @Setter
    @Getter
    private Date modifiedTime;

}
