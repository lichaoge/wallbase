package tv.wallbase.test.mapper;

import tv.wallbase.common.rest.Pageable;
import tv.wallbase.gateway.domain.WallpaperPo;
import tv.wallbase.gateway.enums.Purity;
import tv.wallbase.gateway.model.Wallpaper;
import tv.wallbase.mapper.WallpaperMapper;
import tv.wallbase.test.TestBase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangkun23 on 2017/7/30.
 */
public class WallpaperMapperTest extends TestBase {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private WallpaperMapper wallpaperMapper;


    @Test
    public void insert() {
        WallpaperPo entity = new WallpaperPo();

        entity.setCategoryId(1);
        entity.setPurity(Purity.NSFW);
        entity.setViewsCount(0);
        entity.setFavoritesCount(0);
        entity.setSize(152d);
        entity.setImageUrl("http://imgs1.lockbur.com/group1/M00/08/F9/eznwC1YkoHCAGa24AABYvk7fAVs719.jpg");
        entity.setThumbUrl("http://imgs1.lockbur.com/group1/M00/08/F9/eznwC1YkoHCAGa24AABYvk7fAVs719.jpg");
        entity.setUserId(1);
        entity.setStatus(0);

        wallpaperMapper.insert(entity);
    }


    @Test
    public void findByPage() {
        Pageable pageable = new Pageable();
        List<Wallpaper> list = wallpaperMapper.findByPage(pageable);

        Long count = wallpaperMapper.countByPage(pageable);
        logger.info("count {}", count);

        logger.info("list {}", list.size());
    }
}
