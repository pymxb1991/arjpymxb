package com.pymxb;

import com.pymxb.fruit.FruitApplication;
import com.pymxb.fruit.factory.FruitStrategyFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FruitApplication.class)
public class FruitStrategyTest {
    @Test
    public  void testTransfer(){
        FruitStrategyFactory.getStrategyMap("apple").eatFruit();
    }

}
