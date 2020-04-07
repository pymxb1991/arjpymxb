package com.pymxb.dao.Impl;

import com.pymxb.dao.IAccountDao;
import com.pymxb.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * This is Description
 *
 * @author Mr.Mao
 * @date 2020/04/07
 */
public class UserDaoImpl implements IAccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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