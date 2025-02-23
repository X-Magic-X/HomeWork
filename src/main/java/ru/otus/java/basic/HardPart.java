package ru.otus.java.basic;

import java.util.Arrays;

public class HardPart {
    public static void start() {
        int[] array1 = {2, 4, 65, 1, 3, 6, 7};
        int[] array2 = {1, 5, 1, 8};
        int[] array3 = {5, 4, 3, 2, 1};
        int[] array4 = {3, 2, 2, 1, 1, 1};
        int[] array5 = {1, 1, 1, 2, 2, 3};
        int[] array6 = {};
        int[] result = arrayPlus(array1, array2, array3, array4);
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
        System.out.println("\n");

        arrayPoint(array1);
        arrayPoint(array2);
        arrayPoint(array3);
        arrayPoint(array4);
        arrayPoint(array5);
        arrayPoint(array6);
        arrayDirection(array3);
        arraySwap(array1);
        for(int i = 0; i<array1.length; i++)
            System.out.print(array1[i] + " ");
        System.out.println("\n");
    }

    static int[] arrayPlus(int[] array1, int[] array2, int[] array3, int[] array4) {
        int arraysMaxLength = Math.max(Math.max(array1.length, array2.length), Math.max(array3.length, array4.length));
        int[] result = new int[arraysMaxLength];
        for (int i = 0; i < arraysMaxLength; i++) {
            if (array1.length > i)
                result[i] += array1[i];

            if (array2.length > i)
                result[i] += array2[i];

            if (array3.length > i)
                result[i] += array3[i];

            if (array4.length > i)
                result[i] += array4[i];

        }
        return result;
    }

    static void arrayPoint(int[] array) {
        int leftSum = 0;
        int rightSum = 0;
        int j = array.length - 1;
        int i = 0;

        while (i <= j) {
            if (leftSum > rightSum) {
                rightSum += array[j--];
            } else {
                leftSum += array[i++];
            }
        }
        if (leftSum == rightSum && leftSum != 0) {
            for (int k = 0; k < array.length; k++) {
                if (k == i)
                    System.out.print("|");

                System.out.print(array[k]);
            }
            System.out.print("\n");
        } else
            System.out.println(" Точку поставить невозможно.");

    }

    static void arrayDirection(int[] array){
        boolean increase = true;
        boolean decrease = true;
        for(int i = 0; i<array.length-1; i++){
             if(array[i]>=array[i+1]) {
                 increase = false;
             }
            if(array[i]<=array[i+1]) {
                decrease = false;
            }
            if (!increase && !decrease){
                System.out.println("Не по возрастанию и не по убыванию");
                return;
            }
        }
        System.out.println(increase? "По возрастанию" : "По убыванию");
    }

    static void arraySwap(int[] array){
        int a;
        for(int i = 0; i<array.length/2; i++){
            a = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = a;
        }
    }
}