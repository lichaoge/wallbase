package tv.wallbase.test.mapper;

import tv.wallbase.gateway.domain.AuthorityEntity;
import tv.wallbase.mapper.AuthorityMapper;
import tv.wallbase.test.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */
public class AuthorityMapperTest extends TestBase {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Resource
    private AuthorityMapper authorityMapper;

    //@Test
    public void insert() {
        AuthorityEntity authority = new AuthorityEntity();
        authority.setRoleId(1);
        authority.setAuthority("ROLE_USER");
        authority.setCreatorId(1);
        authorityMapper.insert(authority);
    }

   // @Test
    public void findAuthorityByRole() {

        List ins=new ArrayList<>();

        ins.add(1);
        //ins.add(2);

        List<String> list = authorityMapper.findAuthorityByRole(ins);

        LOGGER.info("size {}", list.size());
    }
}
