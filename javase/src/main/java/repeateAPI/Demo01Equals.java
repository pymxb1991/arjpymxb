package repeateAPI;

import entity.Person;

/**
 * This is Description
 *
 * @author Mr.Mao
 * @date 2020/04/09
 */
public class Demo01Equals {
    public static void main(String[] args) {
        Person p1 = new Person("maoxb",29);
        Person p2 = new Person("maoyh",11);
        System.out.println(p1.equals(p2));

        //两个对象的比较，Object类的equals方法,默认比较的是两个对象的地址值
        /**Object类的equals方法,默认比较的是两个对象的地址值,没有意义
         * 所以我们要重写equals方法,比较两个对象的属性
         *
         *     public boolean equals(Object obj) {
         *         return (this == obj);
         *     }
         */
        Object o1 = new Object();
        System.out.println(o1.equals(p1));

    }
}