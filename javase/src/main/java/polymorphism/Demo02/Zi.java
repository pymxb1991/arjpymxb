package polymorphism.Demo02;

/**
 * This is Description
 *
 * @author maoxb
 * @date 2020/04/05
 */
public class Zi extends Fu {

    int num = 20;

    @Override
    public void showNum() {
        System.out.println(num);
    }

    @Override
    public void method(){
        System.out.println("子类方法");
    }
}
