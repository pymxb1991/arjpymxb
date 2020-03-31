package com.pymxb.controller;

import dao.IAccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import service.IAccountService;

@Controller
public class AccountController {
    public static void main(String[] args) {

        //1����ȡ������������
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2������ID ��ȡBean����
        IAccountService accountService =(IAccountService)ac.getBean("accountService");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);

        System.out.println(accountService);
        System.out.println(accountDao);
    }
}
