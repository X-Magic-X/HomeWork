package ru.otus.java.basic;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    private static final String PATH = "src\\main\\java\\ru\\otus\\java\\basic\\";
    public static void main(String[] args) {
        System.out.print("Введите имя файла: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        System.out.print("Введите искомую последовательность символов: ");
        String sequence = scanner.nextLine();

        int result = countSequenceOccurrences(fileName, sequence);
        System.out.println("Найдено: " + result +
                " последовательностей");

    }

    public static int countSequenceOccurrences(String fileName, String sequence){
        int count = 0;
        int sequenceLength = sequence.length();
        char[] sequenceChars = sequence.toCharArray();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(PATH + fileName), StandardCharsets.UTF_8))) {

            char[] buffer = new char[8192];
            int charsRead;
            int matchPosition = 0;

            while ((charsRead = reader.read(buffer)) != -1) {
                for (int i = 0; i < charsRead; i++) {
                    if (buffer[i] == sequenceChars[matchPosition]) {
                        matchPosition++;
                        if (matchPosition == sequenceLength) {
                            count++;
                            matchPosition = 0;
                        }
                    } else {
                        if (matchPosition > 0) {
                            i--;
                        }
                        matchPosition = 0;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

}