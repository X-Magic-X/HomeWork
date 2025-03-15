package ru.otus.java.basic.animals;

public class Cat extends Animal {
    public Cat(String name, int runSpeed, int swimSpeed, int endurance) {
        super(name, runSpeed, swimSpeed, endurance);
    }

    @Override
    protected int calcNewEndurance(int distance) {
        return -1;
    }

    @Override
    public int swim(int distance) {
        System.out.println("Кот не умеет плавать");
        return -1;
    }
}
