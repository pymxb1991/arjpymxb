package com.pymxb.fruit.handler;

import com.pymxb.fruit.factory.FruitStrategyFactory;
import org.springframework.stereotype.Component;

@Component
public class AppleHandler implements  FruitHandler{

    @Override
    public void eatFruit() {
        System.out.println("吃到了  Apple ~~~~~~~");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        FruitStrategyFactory.registerHandler("apple",this);
    }
}
