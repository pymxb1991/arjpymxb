package com.pymxb.service.impl;


import com.pymxb.dao.IAccountDao;
import com.pymxb.domain.Account;
import com.pymxb.service.IAccountService;

import java.util.List;

/**
 * 账户的业务层实现类
 *
 * 事务的控制 都在业务类
 */
public class AccountServiceImpl implements IAccountService {

    /*//注入事务管理
    private TransactionManager tManager;

    public void settManager(TransactionManager tManager) {
        this.tManager = tManager;
    }*/

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        List<Account> allAccount = accountDao.findAllAccount();
        //4、返回结果
        return allAccount;

    }

    @Override
    public Account findAccountById(Integer accountId) {

        Account account = accountDao.findAccountById(accountId);
        //4、返回结果
        return account;
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer acccountId) {
        accountDao.deleteAccount(acccountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        //2、执行操作
        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney()+money);
        //2.5更新转出账户
        accountDao.updateAccount(source);

         int i=1/0;

        //2.6更新转入账户
        accountDao.updateAccount(target);
    }
}
