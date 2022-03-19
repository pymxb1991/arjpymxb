package fruitDemo.factory;

import fruitDemo.handler.FruitHandler;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过工厂获取对应的策略(具体的水果)，通过策略接口去执行具体的方法
 * 优点：代码简洁，方便管理，扩展性较好
 */
public class FruitStrategyFactory {
    //用来存储具体的水果策略，key为上述if中的判断条件，value为FruitHandler类型的实现类(相当于把原先的if判断交给了map)
    public  static Map<String , FruitHandler> fruitStrategyMap = new HashMap<String, FruitHandler>();

    /**
     * 获取对应的FruitHandler(key通常为原先if中的判断条件，需要自己去规定)
     * @param fruitName
     * @return
     */
    public static FruitHandler getStrategyMap(String fruitName){
        return fruitStrategyMap.get(fruitName);
    }

    /**
     * 在策略接口的实现类在afterPropertiesSet()方法中利用registerHandler()方法将当前实现类注册到fruitStrategyMap中
     * @param handleName
     * @param handler
     */
    public static void registerHandler(String handleName,FruitHandler handler){
        if (StringUtils.isEmpty(handleName) || handler == null) return;
        fruitStrategyMap.put(handleName,handler);
    }
}
