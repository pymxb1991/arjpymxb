package com.pymxb.dao.Impl;

import com.pymxb.dao.IAccountDao;
import com.pymxb.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is Description
 *
 * @author Mr.Mao
 * @date 2020/04/07
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    /**
     * 由于 extends JdbcDaoSupport ,使用的是Spring 自带的，所以这种方式不支持注解，
     *  想要注入只能是Jdbctemplate 注入进来
     *
     *  但是Bean.xml 中没有 配置 Jdbctemplate，所以我们需要把Jdbctemplate交给spring 来进行管理
     *
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> accountList = jdbcTemplate.query("select * from account  where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> accountList = jdbcTemplate.query("select * from account where name = ? ", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if (accountList.isEmpty())
            return  null;
        if (accountList.size()>1)
            throw new RuntimeException("结果集不唯一！");
        return accountList.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ? ,money= ? where id = ? ", account.getName(), account.getMoney(), account.getId());
    }
}