package ru.otus.java.basic;

public class Box {
    private int size;
    private String color;
    private boolean isOpened;
    private String item;

    public Box(String color, int size) {
        this.color = color;
        this.size = size;
        isOpened = false;
    }

    public void open() {
        if (isOpened) {
            System.out.println("Коробка уже открыта");
            return;
        }
        System.out.println("Коробка открыта");
        isOpened = true;
    }

    public void close() {
        if (!isOpened) {
            System.out.println("Коробка уже закрыта");
            return;
        }
        System.out.println("Коробка закрыта");
        isOpened = false;
    }

    public void setColor(String color) {
        this.color = color;
        System.out.println("Коробка успешно перекрашена в " + color);
    }

    public void info() {
        System.out.println("Размер: " + size + "\nЦвет: " + color + "\nПредмет внутри: " + item + "\nСостояние: " + (isOpened ? "открыта" : "закрыта"));
    }

    public String getItem() {
        if (item != null)
            System.out.println("В коробке лежит: " + item);
        else System.out.println("Коробка пуста");
        return item;
    }

    public void setItem(String item) {
        if (isOpened) {
            if (this.item == null) {
                this.item = item;
                System.out.println("Предмет успешно помещен в коробку");
            } else System.out.println("В коробке уже есть предмет: " + item);
        } else System.out.println("Сначала откройте коробку");
    }

    public void dropItem() {
        if (isOpened) {
            if (item != null) {
                item = null;
                System.out.println("Предмет выброшен");
            } else System.out.println("Коробка и так пуста");
        } else System.out.println("Сначала откройте коробку");
    }
}
