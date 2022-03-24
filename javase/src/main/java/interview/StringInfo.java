package interview;

public class StringInfo {
    public static void main(String[] args) {
       test();
       /* System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());*/
    }
    /**
     *
     * 　　在前面一篇讲解关于JVM内存机制的一篇博文中提到 ，在class文件中有一部分 来存储编译期间生成的 字面常量以及符号引用，
     * 这部分叫做class文件常量池，在运行期间对应着方法区的运行时常量池。
     * 　　因此在上述代码中，String str1 = "hello world";和String str3 = "hello world"; 都在编译期间生成了 字面常量和符号引用，
     * 运行期间字面常量"hello world"被存储在运行时常量池（当然只保存了一份）。通过这种方式来将String对象跟引用绑定的话，
     * JVM执行引擎会先在运行时常量池查找是否存在相同的字面常量，如果存在，则直接将引用指向已经存在的字面常量；
     * 否则在运行时常量池开辟一个空间来存储该字面常量，并将引用指向该字面常量。
     *
     * 　　总所周知，通过new关键字来生成对象是在堆区进行的，而在堆区进行对象生成的过程是不会去检测该对象是否已经存在的。
     * 因此通过new来创建对象，创建出的一定是不同的对象，即使字符串的内容是相同的。
     */
    public static void test(){
        String str1 = "hello world";
        String str2 = new String("hello world");
        String str3 = "hello world";
        String str4 = new String("hello world");

        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str2==str4);
    }

}
