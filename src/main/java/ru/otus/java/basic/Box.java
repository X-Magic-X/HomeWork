package ru.otus.java.basic;

import ru.otus.java.basic.Fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<Fruit> items = new ArrayList<>();

    public void insert(Fruit item) {
        items.add(item);
    }

    public int weith() {
        int result = 0;
        for (Fruit i : items) {
            result += i.getWeith();
        }

        return result;
    }

    public boolean compare(Box<?> box) {
        return this.weith() == box.weith();
    }

    private void clear() {
        items.clear();

    }

    public boolean transferTo(Box<? super T> box) {
        if (this == box) {
            return false;
        }
        if (items.isEmpty()) {
            return false;
        }
        for (Fruit i : items) {
            box.insert(i);
        }
        clear();
        return true;
    }
}
