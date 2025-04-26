package ru.otus.java.basic;

public class Main {
    public static void main(String[] args) {
        arrayFill();
        arrayFillMultithreading();
    }

    public static void arrayFill() {
        Timer timer = new Timer();
        double[] array = new double[100_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        timer.stop();
    }

    public static void arrayFillMultithreading() {
        double[] array = new double[100_000_000];
        int quarter = array.length / 4;
        Timer timer = new Timer();
        Thread t1 = new Thread(() -> {
            proc(quarter * 0, quarter * 1, array);
        });
        Thread t2 = new Thread(() -> {
            proc(quarter * 1, quarter * 2, array);
        });
        Thread t3 = new Thread(() -> {
            proc(quarter * 2, quarter * 3, array);
        });
        Thread t4 = new Thread(() -> {
            proc(quarter * 3, quarter * 4, array);
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        timer.stop();
    }

    private static void proc(int from, int until, double[] array) {
        for (int i = from; i < until; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }
}