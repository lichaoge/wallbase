package tv.wallbase.mapper;


import org.apache.ibatis.annotations.Mapper;
import tv.wallbase.gateway.domain.AuthorityEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */
@Mapper
public interface AuthorityMapper {

    public void insert(AuthorityEntity entity);

    public List<String> findAuthorityByRole(List<Long> roleIds);
}
