package ru.otus.java.basic.Transport;

import ru.otus.java.basic.TerrainType;

public class Car implements Transport {
    String name;
    int maxFuel;
    int fuel;

    public Car(String name, int maxFuel, int fuel) {
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
        if (terrain == TerrainType.SWAMP || terrain == TerrainType.DENSE_FOREST) {
            System.out.println("Машина не может перемещаться по " + terrain.getDescription());
            return false;
        }
        if (calcNewFuel(distance) >= 0) {
            fuel = calcNewFuel(distance);
            System.out.println("Машина " + name + " проехала " + distance + " км по " + terrain.getDescription() +
                    " осталось топлива: " + fuel + "/" + maxFuel);
            return true;
        } else {
            System.out.println("Недостаточно топлива");
            return false;
        }
    }

    public void refuel(int amount) {
        if (amount + fuel > maxFuel) {
            System.out.println("В бак не влезет столько топлива");
            return;
        }
        fuel += amount;
        System.out.println("Машина заправлена. Теперь бензина: " + fuel + "/" + maxFuel);
    }

    @Override
    public String getName() {
        return name;
    }

    public int calcNewFuel(int distance) {
        return fuel - distance;
    }
}
