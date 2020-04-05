package polymorphism.Demo02;

/**
 * 成员变量访问规则
 *
 * 代码当中体现多态性，其它就是一句话，父类引用指向子类对象
 *
 * 访问成员变量的两种方式
 *
 *  1、直接通过对象名称访问成员变量：看等号左边是谁，优先用谁，没有则向上找
 *  2、间接通过成员方法访问 ： 看该方法属于谁，优先用谁，没有则向上找。
 */
public class Demo01MultiField {
    public static void main(String[] args) {
       //多态写法

        //左侧父类的引用，指向了右侧子类的对象
        Fu obj = new Zi();
        int num = obj.num;//访问成员变量 ：注意 成员变量是不能被覆盖重写的；

        System.out.println(num);

        obj.showNum(); //子类没有覆盖重写，就是父类成员变量值；
        obj.showNum(); //子类覆盖重写，就是子类的成员变量值；
    }
}
