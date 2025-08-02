package ru.otus.java.basic.Transport;

import ru.otus.java.basic.TerrainType;

public class Horse implements Transport {
    String name;
    int maxStamina;
    int stamina;

    public Horse(String name, int maxStamina, int stamina) {
        this.name = name;
        this.maxStamina = maxStamina;
        this.stamina = stamina;
    }

    @Override
    public boolean move(int distance, TerrainType terrain) {
        if (distance <= 0) {
            System.out.println("Дистанция не может быть меньше 1");
            return false;
        }
        if (terrain == TerrainType.SWAMP) {
            System.out.println("Лошадь не может перемещаться по " + terrain.getDescription());
            return false;
        }
        if (calcNewStamina(distance) >= 0) {
            stamina = calcNewStamina(distance);
            System.out.println("Лошадь " + name + " прошла " + distance + " км по " + terrain.getDescription() +
                    " осталось сил: " + stamina + "/" + maxStamina);
            return true;
        } else {
            System.out.println("Лошадь слишком устала");
            return false;
        }
    }

    public void eat(int amount) {
        stamina = Math.min(maxStamina, amount);
        System.out.println("Лошади поела, теперь её силы составляют " + stamina + "/" + maxStamina);
    }

    @Override
    public String getName() {
        return name;
    }

    public int calcNewStamina(int distance) {
        return stamina - distance;
    }
}
