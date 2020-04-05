package polymorphism.Demo02;

/**
 * This is Description
 *
 * @author maoxb
 * @date 2020/04/05
 */
public class Fu {
    int num = 10;

    public  void showNum (){
        System.out.println(num);
    }

    public void method(){
        System.out.println("父类方法");
    }

    public void methodFu(){
        System.out.println("父类特有方法……");
    }
}
