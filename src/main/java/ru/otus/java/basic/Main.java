package ru.otus.java.basic;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String PATH = "src/main/java/ru/otus/java/basic/";
        Scanner scanner = new Scanner(System.in);
        showAllTxtFileByPath(PATH);
        String filePath = selectAndReadFile(PATH);
        String data = scanner.next();
        writeToFile(filePath, data);
    }

    static void showAllTxtFileByPath(String path) {
        File fileDirectory = new File(path);
        File[] listFiles = fileDirectory.listFiles();
        for (File file : listFiles) {
            if (file.getAbsolutePath().endsWith(".txt")) {
                System.out.println(file);
            }
        }
    }

    static String selectAndReadFile(String path) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла с которым хотите работать: ");
        String filePath = path + scanner.next();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(filePath))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

    static void writeToFile(String path, String data) {
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path))) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            for (byte b : buffer) out.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}