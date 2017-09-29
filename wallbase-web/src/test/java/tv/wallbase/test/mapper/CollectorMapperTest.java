package tv.wallbase.test.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tv.wallbase.gateway.enums.CollectorType;
import tv.wallbase.gateway.model.Collector;
import tv.wallbase.mapper.CollectorMapper;

import javax.annotation.Resource;

/**
 * Created by wangkun23 on 2017/9/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectorMapperTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private CollectorMapper collectorMapper;

    @Test
    public void insert() {
        Collector collector = new Collector(CollectorType.WALLHAVEN, "1111111", "https://alpha.wallhaven.cc/");
        collectorMapper.insert(collector);
    }

    @Test
    public void findBySiteAndName() {
        Collector collector = collectorMapper.findBySiteAndName(CollectorType.WALLHAVEN, "1111111");
        logger.info("{}", collector);
    }
}
