package ru.otus.java.basic;

public class Main {
    public static void main(String[] args) {

        Cat[] cats = {
                new Cat(20, "barsik"),
                new Cat(40, "murzik")
        };

        Plate plate = new Plate(50, 50);
        plate.fill(10);

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat.toString());
        }
    }


}