package tv.wallbase.mapper;

import org.apache.ibatis.annotations.Mapper;
import tv.wallbase.gateway.domain.AdminRoleEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */
@Mapper
public interface AdminRoleMapper {

    /**
     * 保存
     *
     * @param entity
     */
    public void insert(AdminRoleEntity entity);

    /**
     * 根据用户名查询用户的角色
     *
     * @param adminId
     * @return
     */
    public List<Long> findRoleIdsByAdmin(long adminId);
}
