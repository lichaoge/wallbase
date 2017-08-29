package tv.wallbase.test.service;

import tv.wallbase.gateway.service.RoleService;
import tv.wallbase.test.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/10/24.
 */
public class RoleServiceTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(ConfigServiceTest.class);

    @Resource
    private RoleService roleService;

    //@Test
    public void get() {
       // List<String> list = roleService.findAuthority(1);
        //logger.info("roleService {}", list.size());
    }
}
