package tv.wallbase.gateway.service;

import tv.wallbase.gateway.model.Account;

/**
 * 账户管理相关
 * Created by wangkun23 on 2017/10/14.
 */
public interface AccountService {

    /**
     * 注册用户
     *
     * @param account
     */
    public void register(Account account);


    /**
     * 更新
     *
     * @param account
     */
    public void update(Account account);


    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    public Account findById(Integer id);

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名(忽略大小写)
     * @return 用户名是否存在
     */
    boolean usernameExists(String username);

    /**
     * 判断E-mail是否存在
     *
     * @param email E-mail(忽略大小写)
     * @return E-mail是否存在
     */
    boolean emailExists(String email);

    /**
     * 根据用户名查找会员
     *
     * @param username 用户名(忽略大小写)
     * @return 会员，若不存在则返回null
     */
    Account findByUsername(String username);

    /**
     * 根据E-mail查找会员
     *
     * @param email E-mail(忽略大小写)
     * @return 会员，若不存在则返回null
     */
    Account findByEmail(String email);
}
