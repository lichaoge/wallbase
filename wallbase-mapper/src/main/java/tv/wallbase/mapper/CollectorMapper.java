package tv.wallbase.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tv.wallbase.gateway.enums.CollectorType;
import tv.wallbase.gateway.model.Collector;

/**
 * 已经采集的图片数据防止重复采集使用
 * Created by wangkun23 on 2017/9/21.
 */
@Mapper
public interface CollectorMapper {

    /**
     * 插入
     *
     * @param entity
     */
    void insert(Collector entity);

    /**
     * 查询网址下的图片是否已经抓取过了
     *
     * @param site
     * @param name
     * @return
     */
    Collector findBySiteAndName(@Param("site") CollectorType site, @Param("name") String name);

}
