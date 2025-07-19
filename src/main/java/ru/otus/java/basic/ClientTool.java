package ru.otus.java.basic;

import java.io.*;

public class ClientTool implements AutoCloseable {
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public ClientTool(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.inputStream = new DataInputStream(inputStream);
        this.outputStream = new DataOutputStream(outputStream);
    }

    public void send(String message) throws IOException {
        outputStream.writeUTF(message);
        outputStream.flush();
    }

    public void read() {
        try {
            String result = inputStream.readUTF();
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Сервер закрыл соединение.");
        }
    }

    @Override
    public void close() throws Exception {
        inputStream.close();
        outputStream.close();
    }
}
