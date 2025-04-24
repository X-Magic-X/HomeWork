package ru.otus.java.basic;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String PATH = "src/main/java/ru/otus/java/basic/";
        Scanner scanner = new Scanner(System.in);
        File fileDirectory = new File(PATH);
        File[] listFiles = fileDirectory.listFiles();
        for (File file : listFiles) {
            if (file.getAbsolutePath().endsWith(".txt")) {
                System.out.println(file);
            }
        }
        System.out.print("Введите имя файла с которым хотите работать: ");
        String name = scanner.next();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(PATH + name))) {
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
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(PATH + name))) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            for (byte b : buffer) out.write(b);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}