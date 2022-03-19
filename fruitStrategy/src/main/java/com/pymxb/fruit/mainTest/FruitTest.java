package com.pymxb.fruit.mainTest;


import com.pymxb.fruit.factory.FruitStrategyFactory;
import org.junit.Test;

public class FruitTest {
    /**
     * 缺点：如果还想吃西瓜的话，还得继续加if判断，同时也不方便水果的统一管理，并且这样做不符合OCP原则(对扩展开放，对修改关闭)。
     */
    @Test
    public  void fruitStrategyTest() {
       // String fruit = "apple";
        // String fruit = "orange";
/*        String fruit = "banana";
        if ("apple".equals(fruit)){
            System.out.println("吃到了  Apple ~~~~~~~");
        }else if ("banana".equals(fruit)){
            System.out.println("吃到了  Banana ~~~~~~");
        }else {
            System.out.println("吃到了  Orange ~~~~~~");
        }*/
        FruitStrategyFactory.getStrategyMap("apple").eatFruit();
    }
}
