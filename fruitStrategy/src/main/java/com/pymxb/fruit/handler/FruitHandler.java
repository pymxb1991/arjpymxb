package com.pymxb.fruit.handler;

import org.springframework.beans.factory.InitializingBean;

/**
 * 创建水果策略接口(由具体的水果抽象出来的)，继承InitializingBean接口。
 * 继承InitializingBean的原因是它包含一个方法afterPropertiesSet，
 * 这个方法将在所有的属性被初始化后调用。
 * 在这里的作用是让实现类在初始化后就将自身自动注册到工厂中(工厂的Map中)。
 */
public interface FruitHandler extends InitializingBean {
    void eatFruit();
}
