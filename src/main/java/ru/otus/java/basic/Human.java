package ru.otus.java.basic;

import ru.otus.java.basic.Transport.Transport;

public class Human {
    private String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
    }

    public void sitToTransport(Transport transport) {
        if (currentTransport != null) {
            System.out.println(name + " уже использует " + currentTransport.getName());
            return;
        }
        currentTransport = transport;
        System.out.println(name + " сел в " + currentTransport.getName());
    }


    public void upFromTransport() {
        if (currentTransport == null) {
            System.out.println(name + " не находится в транспорте");
            return;
        }
        System.out.println(name + " вышел из " + currentTransport.getName());
        currentTransport = null;
    }

    public boolean move(int distance, TerrainType terrain) {
        if (distance <= 0) {
            System.out.println("Дистнация не может быть меньше 1");
            return false;
        }
        if (currentTransport == null) {
            System.out.println(name + " прошел пешком " + distance + " км по " + terrain.getDescription());
            return true;
        } else {
            return currentTransport.move(distance, terrain);
        }
    }

}
