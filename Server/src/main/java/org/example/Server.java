package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void listen() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept(); // ждем подключения
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("New connection accepted");
        final String name = in.readLine();
        System.out.println("received message: " + name);
        out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
    }
}
