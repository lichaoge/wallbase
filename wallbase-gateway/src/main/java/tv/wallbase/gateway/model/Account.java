package tv.wallbase.gateway.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * tb_account
 * 登录账户信息
 * Created by wangkun23 on 2017/10/13.
 */
@ToString
public class Account implements Serializable {
    /**
     * 用户名
     */
    @Setter
    @Getter
    @NotEmpty
    @Pattern(regexp = "^[0-9a-z_A-Z\\u4e00-\\u9fa5]+$")
    private String username;

    /**
     * 手机
     */
    @Setter
    @Getter
    @Length(max = 200)
    private String mobile;

    /**
     * E-mail
     */
    @Setter
    @Getter
    @NotEmpty
    @Email
    @Length(max = 200)
    private String email;

    /**
     * 密码
     */
    @Setter
    @Getter
    @NotEmpty
    @Pattern(regexp = "^[^\\s&\"<>]+$")
    private String password;

    /**
     * 安全密匙
     */
    @Setter
    @Getter
    private String salt;

    /**
     * @ 会员头像文件名
     * @ 这里虽然有Avatar 字段但只是保留上传的文件名 真正获取头像是跟会员id和s(大小)来确定
     */
    @Setter
    @Getter
    @Length(max = 120)
    private String avatar;

//    /**
//     * 会员头像文件名
//     */
//    @Setter
//    @Getter
//    @Length(max = 10)
//    private String avatarType;

    /**
     * 是否启用
     */
    @Setter
    @Getter
    @NotNull
    private Boolean enabled;

    /**
     * 是否锁定
     */
    @Setter
    @Getter
    private Boolean locked;

    /**
     * 连续登录失败次数
     */
    @Setter
    @Getter
    private Integer loginFailureCount;

    /**
     * 锁定日期
     */
    @Setter
    @Getter
    private Date lockedDate;

    /**
     * 最后登录IP
     */
    @Setter
    @Getter
    private String loginIp;

    /**
     * 最后登录日期
     */
    @Setter
    @Getter
    private Date loginDate;

    @Setter
    @Getter
    private Date createTime;

    @Setter
    @Getter
    private Date updateTime;
}
