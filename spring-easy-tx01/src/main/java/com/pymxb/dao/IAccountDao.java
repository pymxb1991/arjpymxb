package com.pymxb.dao;

import com.pymxb.domain.Account;

/**
 * 账户的持久层接口
 *
 * @author Mr.Mao
 * @date 2020/04/07
 */
public interface IAccountDao {
    /**
     * 根据Id查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}