package ru.otus.java.basic.Transport;

import ru.otus.java.basic.TerrainType;

public class Bike implements Transport {
    String name;

    public Bike(String name) {
        this.name = name;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (distance <= 0) {
            System.out.println("Дистанция не может быть меньше 1");
            return false;
        }
        if (terrain == TerrainType.SWAMP) {
            System.out.println("Велосипед не может ехать по " + terrain.getDescription());
            return false;
        }
        System.out.println("Велоспидед " + name + " проехал " + distance + " км по " + terrain.getDescription());
        return true;
    }


    @Override
    public String getName() {
        return name;
    }
}
