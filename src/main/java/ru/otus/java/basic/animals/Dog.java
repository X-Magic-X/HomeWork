package ru.otus.java.basic.animals;

public class Dog extends Animal {
    public Dog(String name, int runSpeed, int swimSpeed, int endurance) {
        super(name, runSpeed, swimSpeed, endurance);
    }

    @Override
    protected int calcNewEndurance(int distance) {
        return endurance - distance * 2;
    }
}
