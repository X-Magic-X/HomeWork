package ru.otus.java.basic;

import ru.otus.java.basic.animals.Dog;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Richard", 1, 1, 200);

        System.out.println(dog.run(52));
        dog.info();
        System.out.println("*********************");
        System.out.println(dog.swim(152));
        dog.info();
        System.out.println("*********************");
        System.out.println(dog.swim(822 + 1));
        dog.info();
        System.out.println("*********************");
        System.out.println(dog.swim(1));
        dog.info();
    }
}
