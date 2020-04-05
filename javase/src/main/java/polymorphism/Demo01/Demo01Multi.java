package polymorphism.Demo01;

/**
 * 代码当中体现多态性，其它就是一句话，父类引用指向子类对象
 * 格式：
 *     父类名称   对象名称  =  new  子类名称（）      左父右子
 *  或者      接口实现关系也一样
 *     接口名称  对象名称 =  new  实现类名称（）；
 *
 *     extend   implements  都能作为多态性的体现前提
 *
 *    就一句话：左父，右子就是多态，右侧子类对象就被当做父类进行使用，一只猫被当做动物看待，这是没有问题的，
 *    因为子类就是一个父类，在这里体现了面向对象的多态性
 *
 */
public class Demo01Multi  {
    public static void main(String[] args) {
       //多态写法

        //左侧父类的引用，指向了右侧子类的对象
        Fu obj = new Zi();
        obj.method(); //访问成员方法 ：规律：new 的谁用的谁方法；

        obj.methodFu();
    }
}
