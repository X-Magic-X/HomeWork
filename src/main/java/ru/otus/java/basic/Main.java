package ru.otus.java.basic;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File fileDirectory = new File("src/main/java/ru/otus/java/basic");
        File[] listFiles = fileDirectory.listFiles();
        for (File file : listFiles) {
            if (file.getAbsolutePath().endsWith(".txt")) {
                System.out.println(file);
            }
        }
        System.out.print("Введите имя файла с которым хотите работать: ");
        String name = scanner.next();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/main/java/ru/otus/java/basic/" + name))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String data = scanner.next();
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("src/main/java/ru/otus/java/basic/" + name))) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            for (byte b : buffer) out.write(b);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}