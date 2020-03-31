package com.pymxb.service.impl;

import com.pymxb.dao.IAccountDao;
import com.pymxb.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "accountService") //��ֻ��һ��value ����ʱ�����Բ�д
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
