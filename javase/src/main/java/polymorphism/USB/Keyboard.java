package polymorphism.USB;

/**
 *   键盘就是一个USB  ,笔记本电脑 可不是一个USB
 *
 * @author maoxb
 * @date 2020/04/05
 */
public class Keyboard implements  USB { //把键盘看作是一个USB  ,笔记本电脑 可不是一个USB
    @Override
    public void open() {
        System.out.println("打开键盘");
    }

    @Override
    public void close() {
        System.out.println("关闭键盘");
    }

    public void input(){
        System.out.println("键盘输入");
    }
}
