package tv.wallbase.test.mapper;

import tv.wallbase.gateway.domain.AdminRoleEntity;
import tv.wallbase.mapper.AdminRoleMapper;
import tv.wallbase.test.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/10/24.
 */
public class AdminRoleMapperTest extends TestBase {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Resource
    private AdminRoleMapper adminRoleMapper;

    //@Test
    public void insert() {
        AdminRoleEntity entity = new AdminRoleEntity();
        entity.setRoleId(1);
        entity.setAdminId(2);
        entity.setCreatorId(1);
        adminRoleMapper.insert(entity);
    }

}
