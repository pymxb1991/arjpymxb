package repeateAPI;

import java.util.Objects;

/**
 * This is Description
 *
 * @author Mr.Mao
 * @date 2020/04/10
 */
public class Demo2Objects {
    public static void main(String[] args) {
        // 1、正常情况下
        String st1 = "abc";
        String st2 = "abb";
        System.out.println(st1.equals(st2));
        // 2、如果前者为null,由于 null是不能调用方法的,会抛出空指针异常
        String st3 = null;
      //  System.out.println(st3.equals(st2));
        //3、使用JDK7以后提供的一个object 提供的工具类 Objects,
        // Objects 中的方法是null-save (空指针安全)
        //                  null-tolerant (容忍空指针的)
         /*
            Objects类的equals方法:对两个对象进行比较,防止空指针异常
            public static boolean equals(Object a, Object b) {
                return (a == b) || (a != null && a.equals(b));
            }
               ||只要满足第一个条件，后面的条件就不再判断
               &&只要第一个条件不满足，后面条件就不再判断
         */
        System.out.println(Objects.equals(st3,st2));


    }
}