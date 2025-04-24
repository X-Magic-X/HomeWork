package ru.otus.java.basic;

import java.io.*;

public class ClientTool implements AutoCloseable {
    private final ObjectInputStream inputStream;
    private final ObjectOutputStream outputStream;

    public ClientTool(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.inputStream = new ObjectInputStream(inputStream);
        this.outputStream = new ObjectOutputStream(outputStream);
    }

    public void send(String[] message) throws IOException {
        outputStream.writeObject(message);
        outputStream.flush();
        try {
            String result = inputStream.readUTF();
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Сервер закрыл соединение");
        }
    }

    @Override
    public void close() throws Exception {
        inputStream.close();
        outputStream.close();
    }
}
