package polymorphism.Demo02;

/**
 * 成员方法访问规则
 *在多态的代码当中，成员方法的访问规则是：
 *     看new的是谁，就优先用谁，没有则向上找。
 *
 * 口诀：编译看左边，运行看右边。
 *
 * 对比一下：
 * 成员变量：编译看左边，运行还看左边。
 * 成员方法：编译看左边，运行看右边。
 *
 */
public class Demo02MultiMethod {
    public static void main(String[] args) {
       //多态写法

        //左侧父类的引用，指向了右侧子类的对象
        Fu obj = new Zi();

        obj.method(); //父子都有，优先用子
        obj.methodFu();//子类没有，父类有，向上找到父类
    }
}
