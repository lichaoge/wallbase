package tv.wallbase.gateway.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tv.wallbase.gateway.enums.Oauth2Type;

/**
 * 开放社区绑定关系
 * Created by wangkun23 on 2017/9/12.
 */
@ToString
public class Oauth2Bind {

    @Setter
    @Getter
    private String openid;

    @Setter
    @Getter
    private Oauth2Type type;

    @Setter
    @Getter
    private String userId;
}
