package polymorphism;

public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("cat eat fish");
    }

    // 子类特有方法
    public void catchMouse() {
        System.out.println("cat catch mouse");
    }
}
