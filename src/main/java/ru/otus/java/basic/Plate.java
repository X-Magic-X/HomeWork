package ru.otus.java.basic;

public class Plate {
    private int maxAmount;
    private int currentAmount;

    public Plate(int maxAmount, int currentAmount) {
        if (currentAmount > maxAmount || maxAmount < 0 || currentAmount < 0)
            throw new IllegalArgumentException();

        this.maxAmount = maxAmount;
        this.currentAmount = currentAmount;
    }

    public boolean consume(int amount) {
        System.out.println("В тарелке " + currentAmount);
        if (currentAmount >= amount) {
            currentAmount -= amount;
            return true;
        } else return false;
    }

    public void fill(int currentAmount) {
        if (maxAmount >= (this.currentAmount + currentAmount)) {
            this.currentAmount += currentAmount;
        } else
            System.out.println("В тарелке нет столько места");
    }
}
