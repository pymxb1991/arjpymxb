package polymorphism.USB;

/**
 * This is Description
 *
 * @author maoxb
 * @date 2020/04/05
 */
public class Computer {

    /**
     * 开机
     */
    public void  powerOn(){
        System.out.println("笔记本电脑开机");
    }

    public  void powerOff(){
        System.out.println("笔记本电脑关开机");
    }

    /**
     * 使用USB 设备方法
     *  使用接口做为方法的参数
     */
    public void usbDevice(USB usb){
        usb.open();
        if (usb instanceof Mouse){
            Mouse mouse =(Mouse) usb; //向下转型
            mouse.onclick();
        }else if(usb instanceof Keyboard){
            Keyboard keyboard = (Keyboard)usb;//向下转型
            keyboard.input();
        }
        usb.close();
    }
}
