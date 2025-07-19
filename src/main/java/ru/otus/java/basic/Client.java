package ru.otus.java.basic;

import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("localhost", 8091)) {
            System.out.println("Client APP STARTED!");
            ClientTool clientTool = new ClientTool(socket.getInputStream(),
                    socket.getOutputStream());
            Thread readerThread = new Thread(() -> {
                try {
                    while (true) {
                        clientTool.read();
                    }
                } catch (Exception e) {
                    System.out.println("Соединение с сервером прервано");
                }
            });
            readerThread.setDaemon(true);
            readerThread.start();
            while (true) {
                String userMessage = scanner.nextLine();
                if (userMessage.equalsIgnoreCase("exit")) {
                    clientTool.send(userMessage);
                    readerThread.stop();
                    clientTool.close();
                    break;
                }
                clientTool.send(userMessage);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
