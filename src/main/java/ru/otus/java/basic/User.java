package ru.otus.java.basic;

public class User {
    private String surname;
    private String name;
    private String patronymic;
    private int yearOfBirth;
    private String email;

    public User(String surname, String name, String patronymic, int yearOfBirth, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void info() {
        System.out.println("ФИО: " + surname + " " + name + " " + patronymic + "\nГод рождения: " + yearOfBirth + "\nemail: " + email);
    }

}
