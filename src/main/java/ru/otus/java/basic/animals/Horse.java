package ru.otus.java.basic.animals;

public class Horse extends Animal {
    public Horse(String name, int runSpeed, int swimSpeed, int endurance) {
        super(name, runSpeed, swimSpeed, endurance);
    }

    @Override
    protected int calcNewEndurance(int distance) {
        return endurance - distance * 4;
    }
}
