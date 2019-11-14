package com.boroday.echoserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(9081);
             Socket socketToClient = serverSocket.accept();
             BufferedReader bufferedReaderFromClient = new BufferedReader(new InputStreamReader(socketToClient.getInputStream()));
             BufferedWriter bufferedWriterToClient = new BufferedWriter(new OutputStreamWriter(socketToClient.getOutputStream()))) {

            System.out.println("Connection accepted.");

            while (true) {
                bufferedWriterToClient.write("Echo: " + bufferedReaderFromClient.readLine() + '\n');
                bufferedWriterToClient.flush();
            }
        }
    }
}
