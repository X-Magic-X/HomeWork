package ru.otus.java.basic;

public class Main {
    static final char asterisk = '*';


    public static void main(String[] args) {
        int[][] arr = {{-1, 0, 15, 21}, {3, 5, 1, 23, -3}, {18, 0, -5, 1, 4, 2, 6}};
        int[][] arr2 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        int[][] arr3 = {{1, 3, 4, 6}};
        int[][] arr4 = {{-1, -3, -4, -6}};
        System.out.println(sumOfPositiveElements(arr));
        squarePrinter(5);
        nullDiagonally(arr2);
        System.out.println(findMax(arr4));
        System.out.println(sumOfSecondStringElements(arr));
        System.out.println(sumOfSecondStringElements(arr3));
    }

    static int sumOfPositiveElements(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0)
                    sum += arr[i][j];
            }
        }
        return sum;
    }

    static void squarePrinter(int size) {
        char[][] square = new char[size][size];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                square[i][j] = ' ';
            }
        }

        for (int i = 0; i < square.length; i++) {
            square[0][i] = asterisk;
            square[i][0] = asterisk;
            square[square.length - 1][i] = asterisk;
            square[i][square.length - 1] = asterisk;
        }

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void nullDiagonally(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int findMax(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max < array[i][j])
                    max = array[i][j];
            }
        }
        return max;
    }

    static int sumOfSecondStringElements(int[][] arr) {
        int sum = 0;
        try {
            for (int i = 0; i < arr[1].length; i++) {
                sum += arr[1][i];
            }
        } catch (Exception e) {
            return -1;
        }
        return sum;
    }
}