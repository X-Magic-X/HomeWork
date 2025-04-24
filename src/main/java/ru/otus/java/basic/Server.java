package ru.otus.java.basic;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket socket = new ServerSocket(8091);
        System.out.println("Server started");

        while (true) {
            Socket client = socket.accept();
            ObjectInputStream inputStream = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(client.getOutputStream());
            System.out.println("Клиент с поротом " + client.getPort() + " подключился");
            String[] userInput = (String[]) inputStream.readObject();
            for(String s : userInput)
                System.out.println(s);

        }

    }

}

