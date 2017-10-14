package tv.wallbase.service.impl;

import org.springframework.stereotype.Service;
import tv.wallbase.gateway.model.Account;
import tv.wallbase.gateway.service.AccountService;
import tv.wallbase.mapper.AccountMapper;

import javax.annotation.Resource;

/**
 * 账户管理
 * Created by wangkun23 on 2017/10/14.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    /**
     * 注册用户
     *
     * @param account
     */
    @Override
    public void register(Account account) {

    }

    /**
     * 更新
     *
     * @param account
     */
    @Override
    public void update(Account account) {

    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @Override
    public Account findById(Integer id) {
        return accountMapper.findById(id);
    }

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名(忽略大小写)
     * @return 用户名是否存在
     */
    @Override
    public boolean usernameExists(String username) {
        Account account = accountMapper.findByUsername(username);
        return account != null;
    }

    /**
     * 判断E-mail是否存在
     *
     * @param email E-mail(忽略大小写)
     * @return E-mail是否存在
     */
    @Override
    public boolean emailExists(String email) {
        Account account = accountMapper.findByEmail(email);
        return account != null;
    }

    /**
     * 根据用户名查找会员
     *
     * @param username 用户名(忽略大小写)
     * @return 会员，若不存在则返回null
     */
    @Override
    public Account findByUsername(String username) {
        return accountMapper.findByUsername(username);
    }

    /**
     * 根据E-mail查找会员
     *
     * @param email E-mail(忽略大小写)
     * @return 会员，若不存在则返回null
     */
    @Override
    public Account findByEmail(String email) {
        return accountMapper.findByEmail(email);
    }
}
