package com.pymxb.demo.singleton;

/**
 * 懒汉式单例
 * 注意：如果编写的是多线程程序，则不要删除示例代码中的关键字 volatile 和 synchronized，否则将存在线程非安全的问题。
 * 如果不删除这两个关键字就能保证线程安全，
 * 但是每次访问时都要同步，会影响性能，且消耗更多的资源，这是懒汉式单例的缺点。
 */
public class Mgr01 {
    //保证 instance 在所有线程中同步
    private static volatile Mgr01 Instance = null;
    ////private 避免类在外部被实例化
    private Mgr01(){}
    private static synchronized Mgr01 getInstance() {

        //getInstance 方法前加同步
        if (Instance == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Instance = new Mgr01();
        }
        return Instance;
    }

    public static void main(String[] args) {
        for (int i = 0;i<100;i++){
           /* new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Mgr01.getInstance().hashCode());
                }
            }).start();*/
            new Thread(()->{
                System.out.println(Mgr01.getInstance().hashCode());
            }).start();
        }
    }
}
