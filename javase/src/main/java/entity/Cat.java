package entity;

import lombok.Data;

@Data
public class Cat {
    int age;
    String name;

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
