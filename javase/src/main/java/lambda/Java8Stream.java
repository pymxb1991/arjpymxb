package lambda;

import entity.Cat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Stream {
    public static void main(String[] args) {
        // 以下猫的名字均为真名，非虚构
        List<Cat> list = Arrays.asList(
                new Cat(1, "tangyuan"),
                new Cat(3, "dangdang"),
                new Cat(2, "milu"));
        // === 旧代码 Java8之前 ===
        List<Cat> listTemp = new ArrayList<>();
        // 1. 筛选
        for(Cat cat: list){
            if(cat.getAge()>1){
                listTemp.add(cat);
            }
        }
        // 2. 排序
        listTemp.sort(new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                // 递增排序
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        // 3. 提取名字
        List<String> listName = new ArrayList<>();
        for(Cat cat: listTemp){
            listName.add(cat.getName());
        }
        System.out.println(listName);

        // === 新代码 Java8之后 ===
        List<String> listNameNew = list.stream()
                // 函数式接口 Predicate的 boolean test(T t)抽象方法
                .filter(cat -> cat.getAge() > 1)
                // lambda表达式的方法引用
                .sorted(Comparator.comparingInt(Cat::getAge))
                // 函数式接口 Funtion的 R apply(T t)抽象方法
                .map(cat-> cat.getName())
                // 收集数据，把流转为集合List
                .collect(Collectors.toList());
        System.out.println(listNameNew);
    }
}
