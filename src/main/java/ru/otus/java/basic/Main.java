package ru.otus.java.basic;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[4][4];

        try {
            System.out.println(arrayStringSummer(arr));
        } catch (AppArraySizeException | AppArrayDataException e){
            System.out.println("Массив не корректен");
        }

    }

    public static int arrayStringSummer(String[][] arr){
        int result = 0;

        if(arr.length != 4)
        throw new AppArraySizeException();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length != 4)
                throw new AppArraySizeException();

            for (int j = 0; j < arr[i].length; j++) {
                try {
                    result+= Integer.parseInt(arr[i][j]);
                }catch (NumberFormatException e){
                    throw new AppArrayDataException("Некорректные данные в ячейке массива " + i + " " + j);
                }
            }
        }
        return result;
    }
}