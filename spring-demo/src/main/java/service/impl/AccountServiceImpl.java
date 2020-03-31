package service.impl;

import org.springframework.stereotype.Service;
import service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("±£¥Ê’À∫≈≥…π¶ service");
    }
}
