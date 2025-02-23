package ru.otus.java.basic;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {3, 4, 6, 7, 8, 3, 5};
        int[] array2 = new int[8];
        int[] array3 = {4, 8, 3, 2, -4, 1, 5};
        int[] array4 = {2, 4, 6, 9, 1, 3, 5, 6, 1};
        stringPrinter((int) (Math.random() * 10), "JAVA");
        arraySum(array);
        arrayFill((int) (Math.random() * 10), array2);
        arrayPlus((int) (Math.random() * 10), array3);
        arrayHalfMore(array4);
        HardPart.start();
    }

    static void stringPrinter(int count, String text) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    static void arraySum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 5)
                sum += array[i];
        }
        System.out.println(sum);
    }

    static void arrayFill(int number, int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = number;
        // Или можно воспользоваться функцией Arrays.fill(array, number);
    }

    static void arrayPlus(int number, int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] += number;
    }

    static void arrayHalfMore(int[] array) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < array.length / 2; i++) {
            sum1 += array[i];
        }
        for (int i = array.length / 2; i < array.length; i++) {
            sum2 += array[i];
        }

        System.out.println((sum1 > sum2 ? ("Сумма первой половины больше") : ("Сумма второй половины больше")) +
                " sum1=" + sum1 + " sum2=" + sum2);
    }
}