package tv.wallbase.test.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tv.wallbase.gateway.model.Tag;
import tv.wallbase.mapper.TagMapper;

import javax.annotation.Resource;

/**
 * Created by wangkun23 on 2017/9/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TagMapperTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private TagMapper tagMapper;

    @Test
    public void insert() {
        Tag entity = new Tag();

        entity.setName("宝马");
        //entity.setPurity(Purity.NSFW);
        entity.setUserId(1);

        tagMapper.insert(entity);
    }

}
