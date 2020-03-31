package dao.impl;

import dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements IAccountDao {

    @Override
    public void saveAccount() {
        System.out.println("±£¥Ê’À∫≈≥…π¶ dao");
    }
}
