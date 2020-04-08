package com.pymxb.factory;

import com.pymxb.service.IAccountService;
import com.pymxb.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service 的代理工厂类
 *
 * 使用工厂模式构建代理需要的操作
 *      1、把被代理对象注入工厂中，让工厂知道要创建哪个代理；
 *      2、由于增强方法中是对事务进行操作，所以需要把事务管理注入进来；
 *      3、当事务管理在工厂中注入之后，原先的service 中则不需要进行事务操作，直接干掉即可；
 *
 *      4、对bean.xml 进行改造，
 *          1、首先由于service 中已经不需要事务管理，所以直接把service 中对应的事务管理也干掉；
 *              <bean id="accountService" class="com.pymxb.service.impl.AccountServiceImpl">
 *                  <!-- 注入dao set方法注入-->
 *                  <property name="accountDao" ref="accountDao"></property>
 *
 *                  <!-- 注入事务管理器 --><!-- 注意：使用工厂模式代理之后，service 层则不需要进行注入事务 -->
 *                  <!-- <property name="tManager" ref="tManager"></property>-->
 *              </bean>
 *          2、由于使用了工厂模式来进行代理service 所以需要把工厂注入进来，同时，需要把需要被代理的service 和 事务一民注入到工厂里面，交给spring 来进行管理
 *             <!-- 配置beanfactory -->
 *              <bean id="beanFactory" class="com.pymxb.factory.BeanFactory">
 *                  <!-- 注入 Service-->
 *                  <property name="accountService" ref="accountService"></property>
 *                  <!-- 注入事务管理器 --><!-- 注意：使用工厂模式代理之后，service 层则不需要进行注入事务 -->
 *                   <property name="tManager" ref="tManager"></property>
 *              </bean>
 *          3、接下来，我们也不是用旧的service 来进行操作了，而是用我们代理工厂返回的proxyService 来进行操作，所以需要把新的proxyService 交给spring 来进行管理
 *          <!-- 配置代理的Service -->
 *           <bean id="proxyAccountService" factory-bean="beanFactory" factory-method="getAccountService"> </bean>
 *          factory-bean  用实例工厂类
 *          factory-method  基于实例工厂中getAccountService 创建
 *
 *          4、在使用时，需要注意，由于目前已经有两个service 所以需要使用@Qualifier 来进行标注，使用哪个
 *
 */
public class BeanFactory {

    /**
     * 把被代理的 service 注入
     */
    private IAccountService accountService;

    /**
     *
     * @param accountService
     */
    public final void  setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    //注入事务管理
    private TransactionManager tManager;

    public void settManager(TransactionManager tManager) {
        this.tManager = tManager;
    }

    /**
     * 获取 service 代理类
     * @return
     */
    public IAccountService getAccountService() {
        IAccountService proxyAccountService = (IAccountService) Proxy.newProxyInstance(
                accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;

                        try {
                            //1、开启事务
                            tManager.beginTransaction();
                            //2、执行操作;应该就是直接method 对象获取到的方法，然后根据参数进行执行
                            returnValue = method.invoke(accountService, args);
                            //3、提交事务
                            tManager.commit();
                            //4、返回结果
                            return returnValue;
                        } catch (Exception e) {
                            //5回滚操作
                            tManager.rollback();
                            throw new RuntimeException(e); //异常之后不执行，直接抛出
                        } finally {
                            //6释放资源
                            tManager.release();
                        }
                    }
                });
        return proxyAccountService;
    }


}
