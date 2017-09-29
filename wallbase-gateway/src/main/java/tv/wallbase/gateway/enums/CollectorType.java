package tv.wallbase.gateway.enums;

/**
 * 图片采集的网站
 * Created by wangkun23 on 2017/9/29.
 */
public enum CollectorType implements BaseEnum {

    WALLHAVEN("WALLHAVEN"),

    //https://www.pexels.com/
    PEXELS("PEXELS"),

    DEFAULT("默认");//未使用


    private String key;

    CollectorType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
