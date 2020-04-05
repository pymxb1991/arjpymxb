package polymorphism.USB;

/**
 * This is Description
 *
 * @author maoxb
 * @date 2020/04/05
 */
public class DemoMain {

    public static void main(String[] args) {

        // 创建一个笔记本
        Computer computer = new Computer();
        //开机
        computer.powerOn();

        //准备一个鼠标给电脑使用
        //旧时写法  Mouse mouse = new Mouse();
        //向上转型  （左父右子写法）
        USB usbMouse = new Mouse(); //多态写法
        //插入笔记本，(鼠标向上转型之后正好是 USB类型 )
        computer.usbDevice(usbMouse);

        //创建一个键盘
        Keyboard keyboard = new Keyboard();//没有使用多态写法
        /**
         * 注意：可以直接当参数传进来
         * 因为：方法参数是USB 类型，传递进去的是实现类对象
         */
        computer.usbDevice(keyboard);  //此写法也是正确写法，发生了向上转型
      //  computer.usbDevice(new Keyboard());//此种写法也可以

        //实现类向上转型，成为接口类型  --》实现类作为参数keyboard，向上转型则变为USB


        System.out.println("======================基本类型：自动类型转换================================");
        //上面这种方式类似如下形式的调用：double  ->  int 转换

        method(20.5);
        method(10);
        int num = 20;
        method(num);
        System.out.println("=======================基本类型：自动类型转换===============================");
        //关机
        computer.powerOff();
    }

    /**
     *
     * @param num double 类型的参数
     */
    public static void method(double num){
        System.out.println(num);
    }
}
