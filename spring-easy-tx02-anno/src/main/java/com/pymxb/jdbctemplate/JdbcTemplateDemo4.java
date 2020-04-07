package com.pymxb.jdbctemplate;

import com.pymxb.dao.IAccountDao;
import com.pymxb.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This is Description
 *
 * @author Mr.Mao
 * @date 2020/04/07
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {

        //1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = (IAccountDao)ac.getBean("accountDao");
        Account account = accountDao.findAccountById(1);
        System.out.println(account);

        Account eee = accountDao.findAccountByName("eee");
        System.out.println(eee);

        Account accountup = new Account();
        accountup.setId(1);
        accountup.setName("maoxb");
        accountup.setMoney(10000f);
        accountDao.updateAccount(accountup);

    }
}