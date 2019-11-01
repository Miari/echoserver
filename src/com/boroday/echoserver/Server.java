package com.boroday.echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9081);
        Socket socketToClient = serverSocket.accept();
        System.out.println("Connection accepted.");

        byte[] bufferToGet = new byte[20];
        InputStream inputStream = socketToClient.getInputStream();
        inputStream.read(bufferToGet);

        byte[] messageFromServer = new byte[]{101, 99, 104, 111, 58, 32};
        byte[] finalMessage = new byte[bufferToGet.length + messageFromServer.length];
        System.arraycopy(messageFromServer, 0, finalMessage, 0, messageFromServer.length);
        System.arraycopy(bufferToGet, 0, finalMessage, messageFromServer.length, bufferToGet.length);

        OutputStream outputStream = socketToClient.getOutputStream();
        outputStream.write(finalMessage);
    }
}
