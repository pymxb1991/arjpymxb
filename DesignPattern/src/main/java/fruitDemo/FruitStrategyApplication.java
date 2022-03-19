package fruitDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 主类
 */
@SpringBootApplication
public class FruitStrategyApplication{
    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(FruitStrategyApplication.class, args);
    }

}
