package ru.otus.java.basic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list = listFill(2, 8);
        System.out.println(list);
        System.out.println(listSum(list));
        listSetter(list, 15);
        System.out.println(list);
        listPlus(list, 5);
        System.out.println(list);
        List<Employee> eList = new ArrayList<>();
        Employee John = new Employee("John", 42);
        Employee Jack = new Employee("Jack", 52);
        eList.add(John);
        eList.add(Jack);
        System.out.println(employeeNames(eList));
        System.out.println(employeeOldest(eList, 45));
        System.out.println(employeeMediumAge(eList, 47));
        System.out.println(employeeYoung(eList));

    }

    public static List listFill(int min, int max) {
        List<Integer> list = new ArrayList<>();
        if (min > max) throw new IllegalArgumentException("Минимальное значение не может быть больше максимального");
        for (int i = min; i <= max; i++)
            list.add(i);

        return list;
    }

    public static int listSum(Iterable<Integer> list) {
        int result = 0;
        for (int i : list)
            if (i > 5)
                result += i;

        return result;
    }

    public static void listSetter(List<Integer> list, int value) {
        for (int i = 0; i < list.size(); i++)
            list.set(i, value);

    }

    public static void listPlus(List<Integer> list, int value) {
        for (int i = 0; i < list.size(); i++)
            list.set(i, list.get(i) + value);
    }

    public static List<String> employeeNames(Iterable<Employee> list) {
        List<String> result = new ArrayList<>();
        for (Employee e : list)
            result.add(e.getName());

        return result;
    }

    public static List<Employee> employeeOldest(Iterable<Employee> list, int age) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : list)
            if (e.getAge() >= age)
                result.add(e);

        return result;
    }

    public static boolean employeeMediumAge(List<Employee> list, int age) {
        if (list.isEmpty()) throw new IllegalArgumentException("Список пуст");
        int MediumAge = 0;
        for (Employee e : list)
            MediumAge += e.getAge();

        if (MediumAge / list.size() > age)
            return true;

        return false;
    }

    public static Employee employeeYoung(List<Employee> list) {
        if (list.isEmpty()) throw new IllegalArgumentException("Список пуст");
        Employee result = list.get(0);
        for (int i = 1; i < list.size(); i++)
            if (result.getAge() > list.get(i).getAge())
                result = list.get(i);

        return result;
    }
}