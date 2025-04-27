package ru.otus.java.basic;


public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alex", Position.DIRECTOR, 1L);
        Person person2 = new Person("Jack", Position.DRIVER, 2L);

        PersonDataBase base = new PersonDataBase();
        base.add(person);
        base.add(person2);
        System.out.println(base.findByld(2L));
        System.out.println(base.isManager(person2));
        System.out.println(base.isEmployee(2L));

        int[] arr = {1, 2, 52, 4, 47, 6, 152, 8};
        ArrayTool.bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}