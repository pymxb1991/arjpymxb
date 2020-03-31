package com.pymxb.service.impl;

import com.pymxb.dao.IAccountDao;
import com.pymxb.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "accountService") //当只有一个value 属性时，可以不写
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
