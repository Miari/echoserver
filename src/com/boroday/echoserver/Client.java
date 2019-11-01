package com.boroday.echoserver;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        System.out.println("Input your string:");
        int input = 0;
        int index = 0;
        InputStream inputStreamForConsole = System.in;
        byte[] stringToSend = new byte[20];

        while (input != 10) {
            input = inputStreamForConsole.read();
            stringToSend[index] = (byte) input;
            index++;
        }

        Socket socketToServer = new Socket("localhost", 9081);
        OutputStream outputStream = socketToServer.getOutputStream();
        outputStream.write(stringToSend);

        byte[] bufferToReceive = new byte[30];
        InputStream inputStream = socketToServer.getInputStream();
        inputStream.read(bufferToReceive);

        for (int i = 0; i < bufferToReceive.length; i++) {
            System.out.print((char) bufferToReceive[i]);
        }
    }

    public byte[] readFromConsole() throws IOException {
        System.out.println("Input your string:");
        int input = 0;
        int index = 0;
        InputStream inputStreamForConsole = System.in;
        byte[] stringToSend = new byte[20];

        while (input != 10) {
            input = inputStreamForConsole.read();
            stringToSend[index] = (byte) input;
            index++;
        }
        return stringToSend;
    }
}
