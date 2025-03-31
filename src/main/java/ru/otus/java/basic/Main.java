package ru.otus.java.basic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(4);
        list = listFill(list, 3, 6);
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
        System.out.println(employeeSort(eList, 45));
        System.out.println(employeeMediumAge(eList, 47));
        System.out.println(employeeYoung(eList));

    }

    public static List listFill(List list, int min, int max) {
        for (int i = min; i <= max; i++)
            list.add(i);

        return list;
    }

    public static int listSum(List<Integer> list) {
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

    public static List<String> employeeNames(List<Employee> list) {
        List<String> result = new ArrayList<>();
        for (Employee e : list)
            result.add(e.getName());

        return result;
    }

    public static List<Employee> employeeSort(List<Employee> list, int age) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : list)
            if (e.getAge() >= age)
                result.add(e);

        return result;
    }

    public static boolean employeeMediumAge(List<Employee> list, int age) {
        int MediumAge = 0;
        for (Employee e : list)
            MediumAge += e.getAge();

        if (MediumAge / list.size() > age)
            return true;

        return false;
    }

    public static Employee employeeYoung(List<Employee> list) {
        Employee result = list.get(0);
        for (Employee e : list) {
            if (result.getAge() > e.getAge())
                result = e;
        }
        return result;
    }
}