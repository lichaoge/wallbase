package tv.wallbase.test.mapper;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import tv.wallbase.common.rest.Pageable;
import tv.wallbase.gateway.enums.Category;
import tv.wallbase.gateway.enums.WallpaperStatus;
import tv.wallbase.gateway.model.Wallpaper;
import tv.wallbase.gateway.enums.Purity;
import tv.wallbase.mapper.WallpaperMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import java.util.List;

import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
/**
 * Created by wangkun23 on 2017/7/30.
 */
@RunWith(SpringRunner.class)
@MybatisTest
public class WallpaperMapperTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private WallpaperMapper wallpaperMapper;


    //@Test
    public void insert() {
        Wallpaper entity = new Wallpaper();

        entity.setCategory(Category.GENERAL);
        entity.setPurity(Purity.NSFW);
        entity.setViewsCount(0);
        entity.setFavoritesCount(0);
        entity.setSize(152d);
        entity.setImageUrl("http://imgs1.lockbur.com/group1/M00/08/F9/eznwC1YkoHCAGa24AABYvk7fAVs719.jpg");
        entity.setThumbUrl("http://imgs1.lockbur.com/group1/M00/08/F9/eznwC1YkoHCAGa24AABYvk7fAVs719.jpg");
        entity.setUserId(1);
        entity.setStatus(WallpaperStatus.UNASSIGNED);

        wallpaperMapper.insert(entity);
    }


    //@Test
    public void findByPage() {
        Pageable pageable = new Pageable();
        List<Wallpaper> list = wallpaperMapper.findByPage(pageable);

        Long count = wallpaperMapper.countByPage(pageable);
        logger.info("count {}", count);

        logger.info("list {}", list.size());
    }
}
