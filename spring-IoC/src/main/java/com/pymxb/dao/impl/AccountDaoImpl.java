package com.pymxb.dao.impl;

import com.pymxb.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements IAccountDao {

    @Override
    public void saveAccount() {
        System.out.println("�����˺ųɹ� dao");
    }
}
