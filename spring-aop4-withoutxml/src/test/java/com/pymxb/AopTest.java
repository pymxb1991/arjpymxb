package com.pymxb;

import com.pymxb.service.IAccountService;
import config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {

    public static void main(String[] args) {
        //1获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2、获取Bean对象
        IAccountService as =  (IAccountService) ac.getBean("accountService");
        //3、执行方法
        as.saveAccount();
        // 如果想要执行出异常通知，可以进行让抛出个异常1/0

    }
}
