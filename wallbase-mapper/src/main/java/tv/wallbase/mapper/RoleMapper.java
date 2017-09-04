package tv.wallbase.mapper;


import org.apache.ibatis.annotations.Mapper;
import tv.wallbase.gateway.domain.RoleEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */
@Mapper
public interface RoleMapper {

    /**
     * 保存
     *
     * @param entity
     */
    public void insert(RoleEntity entity);

    /**
     * 查询用户角色
     *
     * @param adminId
     * @return
     */
    public List<RoleEntity> findRolesByAdmin(long adminId);
}
