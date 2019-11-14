package com.boroday.echoserver;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {

    public static void main(String[] args) throws IOException {

        try (Socket socketToServer = new Socket("localhost", 9081);
             BufferedReader bufferedReaderFromServer = new BufferedReader(new InputStreamReader(socketToServer.getInputStream()));
             BufferedWriter bufferedWriterToServer = new BufferedWriter(new OutputStreamWriter(socketToServer.getOutputStream()))) {

            while (true) {
                bufferedWriterToServer.write(readFromConsole() + '\n');
                bufferedWriterToServer.flush();

                System.out.println(bufferedReaderFromServer.readLine());
            }
        }
    }

    private static String readFromConsole() throws IOException {
        InputStream inputStreamFromConsole = System.in;
        BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(inputStreamFromConsole));
        System.out.println("Please input your string:");
        return bufferedReaderFromConsole.readLine();
    }
}
