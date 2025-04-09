package ru.otus.java.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, HashSet<String>> phoneBook = new HashMap<>();

    public void add(String name, String number) {
        HashSet<String> phoneNumbers = phoneBook.get(name);
        if (phoneNumbers == null) {
            phoneNumbers = new HashSet<>();
            phoneBook.put(name, phoneNumbers);
        }
        phoneNumbers.add(number);

    }

    public Set<String> find(String name) {
        return phoneBook.get(name);
    }

    public boolean containsPhoneNumber(String number) {
        for (HashSet<String> pn : phoneBook.values()) {
            if (pn.contains(number))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "map=" + phoneBook +
                '}';
    }
}
