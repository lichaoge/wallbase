package tv.wallbase.gateway.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Random;

/**
 * oauth2授权客户端
 * Created by wangkun23 on 2017/9/13.
 */
@ToString
public class Oauth2Client implements Serializable {
    // Replace these with your own api key and secret
    @Setter
    @Getter
    private String apiKey;

    @Setter
    @Getter
    private String apiSecret;

    @Setter
    @Getter
    private String callback;

    @Setter
    @Getter
    private String secretState = "secret" + new Random().nextInt();
}
