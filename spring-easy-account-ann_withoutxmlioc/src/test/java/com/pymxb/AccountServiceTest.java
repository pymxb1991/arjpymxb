package com.pymxb;

import com.pymxb.domain.Account;
import com.pymxb.service.IAccountService;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {


    @Test
    public void testFindAll() {
        //1、获取容器
       /* ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");*/
        //1.1当完全不使用配置文件时，可以使用如下方式加载配置
        //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //1.2当创建了JdbcConfig 类时， 如果配置类上都不想写注解@Configuration  可以使用如下配置   要么当参数加上JdbcConfig，要么就是 使用注解，增加扫描配置方式
        //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class, JdbcConfig.class);
        //1.3 比较理想的配置方式 --》引入import 注解
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //1.4 如果创建了配置类如：JdbcConfig  ，此时JdbcConfig 上不想写 @Configuration ，而且@ComponentScan 上也不想再多写其它扫描包时，
        //  可以使用@Import 注解，直接把配置类导入全局配置类中 @Import(JdbcConfig.class)
        //2、得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);


        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindbyId() {
        //1、获取容器
       // ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //如果配置类上都不想写注解@Configuration  可以使用如下配置
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class, JdbcConfig.class);
        //2、得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        //1、获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //如果配置类上都不想写注解@Configuration  可以使用如下配置
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class, JdbcConfig.class);
        //2、得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        //3.执行方法
        as.saveAccount(account);

    }

    @Test
    public void testUpdate() {
        //1、获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
       // AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //如果配置类上都不想写注解@Configuration  可以使用如下配置
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class, JdbcConfig.class);
        //2、得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        //3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //1、获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
       // AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //如果配置类上都不想写注解@Configuration  可以使用如下配置
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class, JdbcConfig.class);
        //2、得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);

        //3.执行方法
        as.deleteAccount(4);
    }
}
