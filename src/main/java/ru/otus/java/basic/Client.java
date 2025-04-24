package ru.otus.java.basic;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String[] userMessage = new String[2];
            try (Socket socket = new Socket("localhost", 8091)) {
                System.out.println("Client APP STARTED!");
                ClientTool clientTool = new ClientTool(socket.getInputStream(),
                        socket.getOutputStream());
                userMessage[0] = scanner.nextLine();
                clientTool.send(userMessage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}