package service.impl;

import org.springframework.stereotype.Service;
import service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("保存账号成功 service");
    }
}
