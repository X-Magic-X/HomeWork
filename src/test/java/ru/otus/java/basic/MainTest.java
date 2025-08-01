package ru.otus.java.basic;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

class MainTest {

    int[] arr1 = new int[]{1, 2, 2, 3, 1, 4, 1, 2, 1};
    int[] arr2 = new int[]{2, 4, 3, 2, 4, 5};
    int[] arr3 = new int[]{1, 1, 1, 2, 2, 1};
    int[] arr4 = new int[]{1, 1, 1, 1};

    @Test
    void nextOfOneOk() {
        List<Integer> actual = Main.nextOfOne(arr1);
        List<Integer> expected = new ArrayList<>(List.of(2, 4, 2));
        Assertions.assertEquals(actual.size(), expected.size());
        for (int i = 0; i < actual.size(); i++) {
            Assertions.assertEquals(actual.get(i), expected.get(i));
        }
    }

    @Test
    void throwNextOfOne() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Main.nextOfOne(arr2);
        });
    }

    @Test
    void checkOfOneTwo() {
        boolean result1 = Main.checkOfOneTwo(arr1);
        boolean result2 = Main.checkOfOneTwo(arr3);
        boolean result3 = Main.checkOfOneTwo(arr4);
        Assertions.assertFalse(result1);
        Assertions.assertTrue(result2);
        Assertions.assertFalse(result3);
    }
}
