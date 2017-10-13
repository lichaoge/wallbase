package tv.wallbase.gateway.enums;

/**
 *
 * 图片的状态信息
 * Created by wangkun23 on 2017/9/14.
 */
public enum WallpaperStatus implements BaseEnum  {

    UNASSIGNED("未处理"),
    ASSIGNED("处理中"),
    CANCELED("已取消"),//只有在UNASSIGNED和ASSIGNED状态的可以取消
    PENDING_APPROVE("待批准"),
    APPROVED("已批准"),
    INDEXED("已索引"),//用来标识是否意见solr建立索引
    REJECTED("已驳回"),
    ARCHIVED("已存档"),
    DELETED("已刪除");

    private final String key;

    private WallpaperStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
