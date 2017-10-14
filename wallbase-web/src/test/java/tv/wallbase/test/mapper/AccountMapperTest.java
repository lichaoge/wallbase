package tv.wallbase.test.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tv.wallbase.gateway.model.Account;
import tv.wallbase.mapper.AccountMapper;
import tv.wallbase.mapper.TagMapper;

import javax.annotation.Resource;

/**
 * Created by wangkun23 on 2017/10/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountMapperTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AccountMapper accountMapper;

    @Test
    public void findById() {
        Account account = accountMapper.findById(1);
        logger.info("account : {}", account);
    }
}
