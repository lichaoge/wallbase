package tv.wallbase.gateway.enums;

/**
 *
 * @author Administrator
 */
public enum EmailType implements BaseEnum {

    MEMBER_RESET_PASSWORD("member.reset.password"),
    /**
     * 超级管理员为管理员设置密码
     */
    ADMIN_RESET_PASSWORD("admin.reset.password"),
    MARKET_REGISTER_ACTIVE("market.register.active");

    private final String key;

    private EmailType(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
