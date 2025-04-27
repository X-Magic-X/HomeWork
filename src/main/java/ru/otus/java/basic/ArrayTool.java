package ru.otus.java.basic;

public class ArrayTool {
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSorted = true;
            for (int j = arr.length - 1; j > 0; j--) {
                int val;
                if (arr[j] > arr[j - 1]) {
                    val = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = val;
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
    }
}
