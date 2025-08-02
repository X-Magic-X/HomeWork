package ru.otus.java.basic.Transport;

import ru.otus.java.basic.TerrainType;

public class AllTerrainVehicle implements Transport {
    String name;
    int maxFuel;
    int fuel;

    public AllTerrainVehicle(String name, int maxFuel, int fuel) {
        this.name = name;
        this.maxFuel = maxFuel;
        this.fuel = fuel;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (distance <= 0) {
            System.out.println("Дистанция не может быть меньше 1");
            return false;
        }
        if (calcNewFuel(distance) >= 0) {
            fuel = calcNewFuel(distance);
            System.out.println("Вездеход " + name + " проехал " + distance + " км по " + terrain.getDescription() +
                    " осталось топлива: " + fuel + "/" + maxFuel);
            return true;
        } else {
            System.out.println("Недостаточно топлива");
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void refuel(int amount) {
        if (amount + fuel > maxFuel) {
            System.out.println("В бак не влезет столько топлива");
            return;
        }
        fuel += amount;
        System.out.println("Вездеход заправлен. Теперь бензина: " + fuel + "/" + maxFuel);
    }

    public int calcNewFuel(int distance) {
        return fuel - distance * 2;
    }
}
