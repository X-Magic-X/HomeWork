package ru.otus.java.basic;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        User[] users = {
                new User("A1", "B1", "C1", 1998, "abcde1@mail.ru"),
                new User("A2", "B2", "C2", 1994, "abcde2@mail.ru"),
                new User("A3", "B3", "C3", 1991, "abcde3@mail.ru"),
                new User("A4", "B4", "C4", 1993, "abcde4@mail.ru"),
                new User("A5", "B5", "C5", 1988, "abcde5@mail.ru"),
                new User("A6", "B6", "C6", 1968, "abcde6@mail.ru"),
                new User("A7", "B7", "C7", 1939, "abcde7@mail.ru"),
                new User("A8", "B8", "C8", 1954, "abcde8@mail.ru"),
                new User("A9", "B9", "C9", 2002, "abcde9@mail.ru"),
                new User("A10", "B10", "C10", 1973, "abcde10@mail.ru")
        };

        for (User u : users) {
            if ((Calendar.getInstance().getWeekYear() - u.getYearOfBirth()) > 40) {
                u.info();
            }
        }
    }
}
