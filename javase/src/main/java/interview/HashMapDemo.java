package interview;

import entity.Person;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Person> personMap = new HashMap<>();
        personMap.put("张三",new Person("张三",21));
        personMap.put("李四",new Person("李四",19));
        personMap.put("王五",new Person("王五",25));
        personMap.put("赵六",new Person("赵六",24));
        personMap.put("孙七",new Person("孙七",32));
        personMap.put("周八",new Person("周八",17));
        personMap.put("钱九",new Person("钱九",24));
        personMap.put("吴十",new Person("吴十",23));

    }
}
