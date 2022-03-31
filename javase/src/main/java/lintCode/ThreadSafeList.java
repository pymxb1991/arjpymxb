package lintCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * 请通过 ThreadSafeList 类的 getList 方法返回一个 List 的实现类，
 * 要求是线程安全的，你可以自己设计一个同步的 List 实现类进行返回。
 * 输入是一个整数 n，我们会向返回的 List 中添加 n * 10 个数据，并输出 List 中的数据个数。
 */
public class ThreadSafeList {
    public static void main(String[] args) throws InterruptedException {
        listThreadSafeTest();
        //listRemoveTest2();
    }

    /**
     * 并发环境下使用ArrayLis
     * ArrayList 线程安全测试
     */
    public static void listThreadSafeTest() throws InterruptedException {
        List<Integer> list = new ArrayList<>();

        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                list.add(i);
            }
        };

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        Thread.sleep(500);
        System.out.println(list.size());
    }

    public List<Integer> getList() {
            // write your code here

        return null;
    }
    public static  void listRemoveTest(){
        // 1.报异常
        // 用for-each循环遍历则会出错
        // checkModificationException 修改次数不一致
        /*List<String> list = new ArrayList<>();
        list.add("沉默王二");
        list.add("沉默王三");
        list.add("一个文章真特么有趣的程序员");

        for (String str : list) {
            if ("沉默王二".equals(str)) {
                list.remove(str);
            }
        }

        System.out.println(list); */


        // 2.将list修改为CopyOnWriteArrayList则可以正常运行。
        // 因为CopyOnWriteArrayList是线程安全的。
		List<String> list = new CopyOnWriteArrayList<>();
        list.add("沉默王二");
        list.add("沉默王三");
        list.add("一个文章真特么有趣的程序员");

        for (String str : list) {
            if ("沉默王二".equals(str)) {
                list.remove(str);
            }
        }

        System.out.println(list);
    }
    public static  void listRemoveTest2(){
        List<String> list = new ArrayList<>();
        list.add("沉默王二");
        list.add("沉默王三");
        list.add("一个文章真特么有趣的程序员");
        List<String> syncList  = Collections.synchronizedList(list);


    }
}
