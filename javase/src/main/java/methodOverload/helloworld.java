package methodOverload;

public class helloworld {
    public static void hello() {
        System.out.println("Hello, world!");
    }

    public static void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void hello(String name, int age) {
        if (age < 18) {
            System.out.println("Hi, " + name + "!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }

    public static void main(String[] args) {

        hello();
        hello("mao");
        hello("mao",12);
        //String类提供了多个重载方法indexOf()，可以查找子串：
        String s = "Test string";
        int n0 = s.indexOf('T');
        int n1 = s.indexOf('t');
        int n2 = s.indexOf("st");
        int n3 = s.indexOf("st", 4);
        System.out.println(n0);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
    }
}
