package polymorphism.USB;

/**
 *   鼠标就是一个USB  ,笔记本电脑 可不是一个USB
 *
 * @author maoxb
 * @date 2020/04/05
 */
public class Mouse implements  USB { //把鼠标看作是一个USB  ,笔记本电脑 可不是一个USB
    @Override
    public void open() {
        System.out.println("打开鼠标");
    }

    @Override
    public void close() {
        System.out.println("关闭鼠标");
    }

    public void onclick(){
        System.out.println("鼠标点击");
    }
}
