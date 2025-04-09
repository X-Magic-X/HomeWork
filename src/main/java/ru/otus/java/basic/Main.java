package ru.otus.java.basic;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Barabanov", "+7305235253");
        phoneBook.add("Barabanov", "84832483284");
        phoneBook.add("Кузьмин Евгений Анатольевич", "+7986539487");

        System.out.println(phoneBook.toString());
        System.out.println(phoneBook.find("Barabanov"));
        System.out.println(phoneBook.containsPhoneNumber("84832483284"));
        System.out.println(phoneBook.containsPhoneNumber("+798539487"));
        System.out.println(phoneBook.find("Кузьмин Евгений Анатольевич"));
    }
}