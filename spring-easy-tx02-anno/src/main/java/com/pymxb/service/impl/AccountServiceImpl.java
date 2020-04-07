package com.pymxb.service.impl;


import com.pymxb.dao.IAccountDao;
import com.pymxb.domain.Account;
import com.pymxb.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账户的业务层实现类
 *
 * 事务控制应该都是在业务层
 *
 *  注意：当一个业务层中有5个查询，5个更新时，使用注释配置就比较麻烦了
 *  另一种配置中最少需要增加5次；
 *  所以，XML 的选择上选择哪一种比较合适，毫无疑问的是 XML的配置是一劳永逸的；
 *  而注解的，可能在一个service 中就需要配置多遍
 *  但是如果单从简单程序上来说，还是注解的方式简单
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true) //只读型事务配置
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false) //读写型事务配置
    public void transfer(String sourceName, String targetName, Float money) {
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

            //int i=1/0;

            //2.6更新转入账户
            accountDao.updateAccount(target);
    }
}
