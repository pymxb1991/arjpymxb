package com.pymxb.test;

import com.pymxb.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用Junit单元测试：测试我们的配置
 *  此示例根据 spring-easy-account01 改编而来
 *  1、因为要使用AOP 来进行事务的操作，所以工作代理模式则不需要了，直接干掉，
 *  2、干掉之后，由于引用了代理的service ，配置文件也进行了注入，都不需要，直接干掉
 *
 *  3、xml 配置AOP 约束
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public  void testTransfer(){
        as.transfer("aaa","bbb",100f);
    }

}
