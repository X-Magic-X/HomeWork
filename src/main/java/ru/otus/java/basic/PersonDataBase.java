package ru.otus.java.basic;

import java.util.EnumSet;
import java.util.HashMap;

public class PersonDataBase {
    private HashMap<Long, Person> persons = new HashMap<>();
    private EnumSet<Position> managerPositions = EnumSet.of(
            Position.MANAGER, Position.DIRECTOR, Position.BRANCH_DIRECTOR, Position.SENIOR_MANAGER
    );

    Person findByld(Long id) {
        return persons.get(id);
    }

    void add(Person person) {
        if (persons.containsKey(person.getId()))
            throw new IllegalArgumentException("Person с таким id уже есть в списке");

        persons.put(person.getId(), person);
    }

    boolean isManager(Person person) {
        return managerPositions.contains(person.getPosition());
    }

    boolean isEmployee(Long id) {
        if (persons.get(id) == null)
            throw new IllegalArgumentException("Person с таким id нет в базе");
        return !isManager(persons.get(id));
    }

}
