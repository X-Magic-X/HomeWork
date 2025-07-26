package ru.otus.java.basic.Fruits;

public abstract class Fruit {
    private final int weith;

    protected Fruit(int weith) {
        if (weith < 0) throw new IllegalArgumentException("вес не может быть отрицательным");
        this.weith = weith;
    }

    public int getWeith() {
        return weith;
    }
}
