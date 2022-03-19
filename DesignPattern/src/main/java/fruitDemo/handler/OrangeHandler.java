package fruitDemo.handler;

import fruitDemo.factory.FruitStrategyFactory;
import org.springframework.stereotype.Component;

@Component
public class OrangeHandler implements  FruitHandler{

    @Override
    public void eatFruit() {
        System.out.println("吃到了  Orange ~~~~~~~");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        FruitStrategyFactory.registerHandler("Orange",this);
    }
}
