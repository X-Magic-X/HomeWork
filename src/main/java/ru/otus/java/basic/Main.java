package ru.otus.java.basic;

import ru.otus.java.basic.Fruits.Apple;
import ru.otus.java.basic.Fruits.Fruit;
import ru.otus.java.basic.Fruits.Orange;


public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Fruit> fruitBox = new Box<>();
        Orange orange = new Orange(5);
        Orange orange1 = new Orange(2);
        Apple apple = new Apple(1);
        appleBox.insert(apple);
        orangeBox.insert(orange1);
        appleBox2.insert(apple);
        appleBox2.insert(apple);
        System.out.println(appleBox.weith());
        System.out.println(appleBox2.weith());
        appleBox.transferTo(appleBox2);
        System.out.println(appleBox.weith());
        System.out.println(appleBox2.weith());

    }
}