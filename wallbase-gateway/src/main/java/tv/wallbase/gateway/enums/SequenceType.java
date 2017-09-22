package tv.wallbase.gateway.enums;

/**
 * 序列号生产类型，如果是新类型。需要重新申请
 * Created by wangkun23 on 2017/9/7.
 */
public enum SequenceType {


    WALLPAPER(1000, "壁纸递增编号"),

    DEFAULT(0, "默认");//未使用


    private Integer key;
    private String value;

    SequenceType(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
