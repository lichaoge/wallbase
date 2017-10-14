package tv.wallbase.mapper;

import org.apache.ibatis.annotations.Mapper;
import tv.wallbase.gateway.model.Account;

/**
 * 账户管理相关
 * Created by wangkun23 on 2017/10/14.
 */
@Mapper
public interface AccountMapper {

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    public Account findById(Integer id);

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    public Account findByUsername(String username);

    /**
     * 根据邮箱查询
     *
     * @param email
     * @return
     */
    public Account findByEmail(String email);
}
