package tv.wallbase.mapper;


import tv.wallbase.gateway.domain.AuthorityEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */
public interface AuthorityDao {

    public void insert(AuthorityEntity entity);

    public List<String> findAuthorityByRole(List<Long> roleIds);
}
