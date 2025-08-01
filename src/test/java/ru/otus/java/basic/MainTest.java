package ru.otus.java.basic;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class MainTest {

    int[] arr1 = new int[]{1, 2, 2, 3, 1, 4, 1, 2, 1};
    int[] arr2 = new int[]{2, 4, 3, 2, 4, 5};

    static Stream<Arguments> checkOfOneTwo() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 3, 1, 4, 1, 2, 1}, false),
                Arguments.of(new int[]{2, 4, 3, 2, 4, 5}, false),
                Arguments.of(new int[]{1, 1, 1, 2, 2, 1}, true),
                Arguments.of(new int[]{1, 1, 1, 1}, false)
        );
    }

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

    @ParameterizedTest
    @MethodSource("checkOfOneTwo")
    void checkOfOneTwo(int[] numbers, boolean expected) {
        boolean actual = Main.checkOfOneTwo(numbers);

        Assertions.assertEquals(actual, expected);
    }
}
