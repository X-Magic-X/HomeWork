package ru.otus.java.basic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static List<Integer> nextOfOne(int[] arr) {
        List<Integer> resList = new ArrayList<>();
        int concurrences = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                concurrences++;
                if (arr.length != i + 1) {
                    resList.add(arr[i + 1]);
                }
            }
        }
        if (concurrences == 0) {
            throw new RuntimeException("Не найдено сопадений");
        }
        return resList;
    }

    public static boolean checkOfOneTwo(int[] arr) {
        boolean hasOne = false;
        boolean hasTwo = false;
        for (int i : arr) {
            switch (i) {
                case 1:
                    hasOne = true;
                    break;
                case 2:
                    hasTwo = true;
                    break;
                default:
                    return false;
            }
        }
        return hasOne && hasTwo;
    }
}