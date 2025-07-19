package ru.otus.java.basic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static DataOutputStream out;
    private static DataInputStream in;
    static ServerSocket socket;


    public static void main(String[] args) throws IOException {
        socket = new ServerSocket(8091);
        System.out.println("Server started");
        Socket client = socket.accept();
        in = new DataInputStream(client.getInputStream());
        out = new DataOutputStream(client.getOutputStream());
        System.out.println("Клиент с поротом " + client.getPort() + " подключился");
        sendMsg("Добро пожаловать в калькулятор! Доступные операции: +, -, *, /");
        while (true) {
            sendMsg("Введите первое число (или 'exit' для выхода): ");
            String input1 = in.readUTF();
            if ("exit".equalsIgnoreCase(input1)) {
                disconnect();
                break;
            }
            sendMsg("Введите второе число: ");
            String input2 = in.readUTF();
            sendMsg("Укажите оператор (+, -, *, /): ");
            String operator = in.readUTF();
            try {
                int num1 = Integer.parseInt(input1);
                int num2 = Integer.parseInt(input2);
                Integer result = calculate(num1, num2, operator);
                if (result != null) {
                    sendMsg("Результат: " + result);
                }
            } catch (NumberFormatException e) {
                sendMsg("Ошибка: введите целые числа");
            }
        }

    }

    private static void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static Integer calculate(int num1, int num2, String operator) {
        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    sendMsg("Делить на 0 нельзя!");
                    return null;
                }
                result = num1 / num2;
                break;
            default:
                sendMsg("Некорректный оператор");
                return null;
        }
        return result;
    }

    private static void disconnect() {
        if (in != null)
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        if (out != null)
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

