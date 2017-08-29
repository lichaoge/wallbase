package tv.wallbase.test.mapper;

import tv.wallbase.gateway.domain.RoleEntity;
import tv.wallbase.mapper.RoleDao;
import tv.wallbase.test.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */
public class RoleDaoTest extends TestBase {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Resource
    private RoleDao roleDao;

    //@Test
    public void insert() {
        RoleEntity role = new RoleEntity();
        role.setName("超级管理员");
        role.setValue("ROLE_ADMIN");
        role.setDescription("描述");
        role.setCreatorId(1);
        roleDao.insert(role);
    }

    //@Test
    public void findRolesByAdmin() {
        List<RoleEntity> list = roleDao.findRolesByAdmin(1);
        LOGGER.info("### {}", list.size());
    }
}