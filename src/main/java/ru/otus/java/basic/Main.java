package ru.otus.java.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final Object mon = new Object();
    private static volatile char currentChar = 'A';
    private static final int COUNT = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> printLetter('A', 'B'));
        executor.submit(() -> printLetter('B', 'C'));
        executor.submit(() -> printLetter('C', 'A'));

        executor.shutdown();
    }

    private static void printLetter(char letter, char nextLetter) {
        for (int i = 0; i < COUNT; i++) {
            synchronized (mon) {
                try {
                    while (currentChar != letter) {
                        mon.wait();
                    }
                    System.out.print(letter);
                    currentChar = nextLetter;
                    mon.notifyAll();
                } catch (InterruptedException e) {
                    throw new  RuntimeException(e);
                }
            }
        }
    }
}
