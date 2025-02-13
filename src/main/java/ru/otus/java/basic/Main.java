package ru.otus.java.basic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер необходимого метода(1-5), либо 0 - выход: ");
        while (true) {
            try {
                switch (scanner.nextInt()) {
                    case 0:
                        return;
                    case 1:
                        greetings();
                        break;
                    case 2:
                        checkSign(
                                (int) (Math.random() * 20) - 10,
                                (int) (Math.random() * 20) - 10,
                                (int) (Math.random() * 20) - 10
                        );
                        break;
                    case 3:
                        selectColor();
                        break;
                    case 4:
                        compareNumbers();
                        break;
                    case 5:
                        addOrSubtractAndPrint(
                                (int) (Math.random() * 10),
                                (int) (Math.random() * 10),
                                Math.random() > 0.5
                        );
                        break;
                    default:
                        System.out.println("Введено некорректное число!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Введено не число!");
            } finally {
                scanner.nextLine();
            }
        }
        /*
        // Сделал запуск по циклу по опросу, а это пока убрал
        greetings();
        checkSign(1, 15, -20);
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint(15, 539, true);
        // */

    }

    static void greetings() {
        System.out.println("Hello\nWorld\nFrom\nJava");
    }

    static void checkSign(int a, int b, int c) {
        int summ = a + b + c;
        if (summ >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }

    static void selectColor() {
        int data = (int) (Math.random() * 30);
        if (data <= 10)
            System.out.println("Красный");
        else if (data <= 20)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");
    }

    static void compareNumbers() {
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * 10);
        if (a >= b)
            System.out.println("a>=b");
        else
            System.out.println("a<b");
    }

    static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        int result;
        if (increment) {
            result = initValue + delta;
        } else {
            result = initValue - delta;
        }
        System.out.println("Результат: " + result);
    }
}