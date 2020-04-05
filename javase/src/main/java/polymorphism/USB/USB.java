package polymorphism.USB;

/**
 * This is Description
 *
 * @author maoxb
 * @date 2020/04/05
 */
public interface USB {

    /**
     * 打开设备
     */
    public abstract void open();

    /**
     * 关闭设备
     */
    public abstract  void close();
}
