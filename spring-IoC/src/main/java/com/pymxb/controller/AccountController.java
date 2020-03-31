package com.pymxb.controller;

import com.pymxb.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Controller

/**
 *  曾经XML 配置
 *     <bean id="accountDao" class="com.pymxb.dao.impl.AccountDaoImpl" scope="" init-method="" destroy-method="">
 *         <property name="" value=""| ref="></property>
 *     </bean>
 *
 *     用于创建对象的
 *           作用：和在XML 配置文件中编写一个<bean> 标签实现的功能是一样的
 *          @Component
 *              作用： 用于把当前类对象存入 Spring 容器
 *              属性：
 *                  value:用于指定bean 的ID ,当我们不写是，它的默认值是当前类名，首字母为小写；
 *          @Controller
 *          @Service
 *          @Repository
 *          以上三个注解他们的作用和属性与Component 是一模一样的；
 *          那添加这三个注解的原因是什么呢？？？？？？    他们是spring框架为我们明确三层使用的注解，使我们的三层对象更加清晰；
 *     用于注入数据的
 *          作用：和在XML 配置文件中的<bean>标签中编写<property>作用是一样的
 *          @Autwired
 *              作用： 自动按照类型注入，只要容器中有唯一的一个bean 对象类型和要注入的变量类型匹配，就可以注入成功
 *                    如果ioc容器中没有任何bean 的类型和要注入的变量类型匹配，则报错，
 *                    如果ioc容器中有多个类型匹配时
 *             出现位置：可以是变量上，也可以是方法上
 *             细节：   在使用注解注入时，set方法就不是必须的了；
 *          @Qualifier
 *              作用：在按照类型注入的基础之上在按钮名称注入，他在给类成员注入时不能单独使用，但是在给方法参数注入时可以；
 *              属性：
 *                value  用于指定注入bean  的ID
 *             注意，此注解必须跟@Autowired 配合使用
 *          @Resource
 *              作用： 直接按照bean 的id 注入，它可以独立使用
 *              属性：
 *  *                value  用于指定注入bean  的ID
 *          以上三个注入都只能注入其它bean 类型的数据，而基础数据类型和String 类型无法使用上述注解实现的。
 *          另外，集合类型的注入只能通过XML来实现；
 *  `       @Value
 *              作用： 用于注入基础类型和String 类型的数据
 *              属性：
 *                   value 用于指定数据的值。它可以使用spring 中的spEL (也就是spring 中的el 表达式)
 *                         SpEL 的写法 ： ${表达式}
 *
 *     用于改变作用范围的
 *        作用： 和在<bean>标签中使用scope 属性实现的功能是一样的；
 *          Scope
 *             作用： 用于指定bean的作用范围
 *              属性：
 *                value 用于指定范围的取值。常用取值： singleton    prototype
 *     和生命周期相关  了解
 *        作用： 和在<bean>标签中使用 init-method  和  destory-method 的作用是一样的；
 *        PreDestory      销毁
 *        PostConstruct   初始化；
 */
public class AccountController {
    public static void main(String[] args) {

        //1、获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、根据ID 获取Bean对象
        IAccountService accountService =(IAccountService)ac.getBean("accountService");
       // IAccountDao accountDao = ac.getBean("accountDaoImpl", IAccountDao.class);
        accountService.saveAccount();
       // System.out.println(accountService);

    }
}
