package tv.wallbase.service.impl;

import javax.annotation.Resource;

import tv.wallbase.mapper.AdminMapper;
import tv.wallbase.gateway.domain.AdminEntity;
import tv.wallbase.gateway.model.Admin;
import tv.wallbase.gateway.service.AdminService;
import tv.wallbase.gateway.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Service实现类 - 管理员
 *
 * @author Administrator
 */

@Service
public class AdminServiceImpl implements AdminService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private RoleService roleService;

    @Override
    public boolean isExistByUsername(String username) {
        return adminMapper.isExistByUsername(username);
    }

    @Override
    public Admin getAdminByUsername(String username) {
        AdminEntity entity = adminMapper.getAdminByUsername(username);

        Admin admin = new Admin();
        BeanUtils.copyProperties(entity, admin);

        return admin;
    }

    @Override
    public List<String> findAuthorities(Long id) {

        List<Long> roleIds = roleService.findRoleIdsByAdmin(id);

        List<String> result = new ArrayList<String>();
        if (!roleIds.isEmpty()) {
            result = roleService.findAuthority(roleIds);
        }
        return result;
    }

}