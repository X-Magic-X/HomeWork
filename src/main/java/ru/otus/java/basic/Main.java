package ru.otus.java.basic;

import ru.otus.java.basic.Transport.*;


public class Main {
    public static void main(String[] args) {
        AllTerrainVehicle allTerrainVehicle = new AllTerrainVehicle("Уаз патриот", 60, 40);
        Human human = new Human("Абубачир");
        human.move(539, TerrainType.PLAIN);
        human.sitToTransport(allTerrainVehicle);
        human.move(20, TerrainType.SWAMP);
        human.upFromTransport();
        human.move(5, TerrainType.PLAIN);
        Car car = new Car("Гранта", 60, 0);
        human.sitToTransport(car);
        human.move(10, TerrainType.PLAIN);
        car.refuel(60);
        human.move(10, TerrainType.SWAMP);
        human.move(10, TerrainType.PLAIN);
        human.upFromTransport();
        Bike bike = new Bike("BMX");
        human.sitToTransport(bike);
        human.move(10, TerrainType.PLAIN);
        human.move(20, TerrainType.SWAMP);
        human.upFromTransport();
        human.upFromTransport();
        Horse horse = new Horse("Буцефал", 200, 100);
        human.sitToTransport(horse);
        human.move(50, TerrainType.SWAMP);
        human.move(50, TerrainType.DENSE_FOREST);
        horse.eat(200);
    }
}