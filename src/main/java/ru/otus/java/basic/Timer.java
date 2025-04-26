package ru.otus.java.basic;

public class Timer {
    private long startTime = System.currentTimeMillis();

    public void stop(){
        long stopTime = System.currentTimeMillis();
        System.out.println((stopTime - startTime));
    }
}
