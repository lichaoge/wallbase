package tv.wallbase.gateway.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tv.wallbase.common.model.BaseEntity;
import tv.wallbase.gateway.enums.CommentsType;

/**
 * 主要记录评论信息
 *
 * @author Administrator
 */
@ToString
public class Comments extends BaseEntity {

    @Setter
    @Getter
    private CommentsType type;
    /**
     * 被评论的主体
     */
    @Setter
    @Getter
    private String entityId;

    @Setter
    @Getter
    private String comment;

    @Setter
    @Getter
    private String userId;
}
