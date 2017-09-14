package tv.wallbase.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tv.wallbase.gateway.model.Tag;

/**
 * 标签tag
 *
 * @author Administrator
 */
@Mapper
public interface TagMapper {


    void insert(Tag tag);

    /**
     * 查询
     *
     * @param name
     * @return
     */
    Tag getByName(@Param("name") String name);


    List<Tag> findTagStringByName(@Param("name") String name);

}
