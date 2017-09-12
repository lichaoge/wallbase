package tv.wallbase.common.utils;

import tv.wallbase.common.enums.BaseEnum;

/**
 * 安全等级.
 * <p>
 * 用于密码生成等多处逻辑
 *
 * @author youyou
 */
public enum SecurityPasswordLevel implements BaseEnum {

    KIDDING("极弱"),
    WEAK("弱"),
    MEDIUM("中等"),
    GOOD("好"),
    STRONG("强"),
    EXTREME("极强"),
    PERFECT("完美");

    private final String key;

    private SecurityPasswordLevel(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
