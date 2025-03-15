package ru.otus.java.basic.animals;


public abstract class Animal {
    protected String name;
    protected int runSpeed;
    protected int swimSpeed;
    protected int endurance;
    protected boolean isTired;

    public Animal(String name, int runSpeed, int swimSpeed, int endurance) {
        this.name = name;
        if (runSpeed <= 0 | swimSpeed <= 0 | endurance < 0)
            throw new IllegalArgumentException();
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.endurance = endurance;
    }

    abstract protected int calcNewEndurance(int distance);

    public int run(int distance) {
        if (distance >= endurance) {
            System.out.println(name + " слишком устал");
            isTired = true;
            return -1;
        }
        System.out.println(name + " пробежался");
        endurance -= distance;
        isTired = false;
        return (distance / runSpeed);
    }


    public int swim(int distance) {
        int newEndurance = calcNewEndurance(distance);
        if (newEndurance < 0) {
            System.out.println("Не достаточно выносливости");
            isTired = true;
            return -1;
        }
        System.out.println(name + " Проплыл");
        endurance = newEndurance;
        isTired = false;
        return (distance / swimSpeed);
    }

    public void info() {
        System.out.println("Имя " + name + "\nСкорость бега " + runSpeed + "\nСкорость плаванья " + swimSpeed + "\nОставшиеся силы " + endurance + "\n" + name + (isTired ? " yставший" : " не уставший"));
    }
}
