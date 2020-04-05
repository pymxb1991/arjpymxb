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
    }
}
