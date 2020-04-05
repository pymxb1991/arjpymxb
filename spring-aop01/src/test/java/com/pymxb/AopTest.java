package com.pymxb;

import com.pymxb.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    public static void main(String[] args) {
        //1获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、获取Bean对象
        IAccountService as =  (IAccountService) ac.getBean("accountService");
        //3、执行方法
        as.saveAccount();
        // 由于切入点配置了增强saveAccount 方法，所以在执行saveAccount方法之前，进行了日志记录；
        //如果执行其它方法如何进行操作,查看配置文件笔记 execution  各种写法
        as.updateAccount(1);
        as.deleteAccount();

    }
}
