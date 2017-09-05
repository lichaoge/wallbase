package tv.wallbase.service.impl;

import tv.wallbase.mapper.AdminRoleMapper;
import tv.wallbase.mapper.AuthorityMapper;
import tv.wallbase.mapper.RoleMapper;
import tv.wallbase.gateway.domain.RoleEntity;
import tv.wallbase.gateway.model.Role;
import tv.wallbase.gateway.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色管理
 * Created by Administrator on 2016/10/24.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private AuthorityMapper authorityMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private AdminRoleMapper adminRoleMapper;

    @Override
    public List<String> findAuthority(List<Long> roleIds) {
        List<String> result = authorityMapper.findAuthorityByRole(roleIds);
        return result;
    }

    @Override
    public List<Role> findRolesByAdmin(long id) {
        List<RoleEntity> list = roleMapper.findRolesByAdmin(id);

        List<Role> result = new ArrayList<>(list.size());
        for (RoleEntity entity : list) {
            Role role = new Role();
            BeanUtils.copyProperties(entity, role);
            result.add(role);
        }
        return result;
    }

    @Override
    public List<Long> findRoleIdsByAdmin(long id) {
        return adminRoleMapper.findRoleIdsByAdmin(id);
    }
}
