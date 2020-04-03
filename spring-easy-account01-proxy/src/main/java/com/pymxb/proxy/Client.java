package com.pymxb.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者 来进行买产品
 */
public class Client {

    public static void main(String[] args) {

        //旧时逻辑，消费者直接找产家，然后付钱买产品:如下逻辑
        final Producer producer = new Producer();
        // producer.sealProduct(10000f);

        //代理商出现了，如何去联系代理商

        /**
         * 动态代理：
         *  特点：字节码随用随创建，随用随加载
         *  作用：不修改源码的基础上对方法增强
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *  基于接口的动态代理：
         *      涉及的类：Proxy
         *      提供者：JDK官方
         *  如何创建代理对象：
         *      使用Proxy类中的newProxyInstance方法
         *  创建代理对象的要求：
         *      被代理类最少实现一个接口，如果没有则不能使用
         *  newProxyInstance方法的参数：
         *      ClassLoader：类加载器 （代理谁写谁）
         *          它是用于加载代理对象字节码的。和被代理对象使用相同的类加载器。固定写法。
         *      Class[]：字节码数组 （代理谁写谁的接口）
         *          它是用于让代理对象和被代理对象有相同方法。固定写法。
         *      InvocationHandler：用于提供增强的代码
         *          它是让我们写如何代理。我们一般都是些一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的。
         *          此接口的实现类都是谁用谁写。
         */

        IProducer proxyProducer = (IProducer)Proxy.newProxyInstance(
                Producer.class.getClassLoader(),//代理谁写谁
                Producer.class.getInterfaces(), //代理谁就写谁的实现接口
                new InvocationHandler() { //
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     * 方法参数的含义
                     * @param proxy   代理对象的引用
                     * @param method  当前执行的方法
                     * @param args    当前执行方法所需的参数
                     * @return        和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //方法执行，谁的方法呢，肯定是被代理类的方法
                        //当匿名内部类，访问外部成员变量时，外部成员要求是最终的，也就是 final 修饰的；

                        // 提供增强方法：(代理商要20%利润)
                        Object value =null;
                        //1、获取方法执行的参数：
                        Float money = (Float)args[0];
                        //2、判断当前方法是不是销售
                        if("sealProduct".equals(method.getName())){
                            value = method.invoke(producer, money*0.8f);
                        }
                        return value;
                    }
                });

        proxyProducer.sealProduct(10000f);
    }
}
