package ru.otus.java.basic;

public class Cat {
    private int appetite;
    private String name;
    private boolean isSatiety;

    public Cat(int appetite, String name) {
        if (appetite < 0)
            throw new IllegalArgumentException();

        this.appetite = appetite;
        this.name = name;
    }


    public void eat(Plate plate) {
        if (plate.consume(appetite)) {
            isSatiety = true;
            System.out.println(name + " поел");
        } else {
            isSatiety = false;
            System.out.println(name + " недоволен");
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "appetite=" + appetite +
                ", name='" + name + '\'' +
                '}';
    }
}
