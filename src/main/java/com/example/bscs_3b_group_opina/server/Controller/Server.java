package com.example.bscs_3b_group_opina.server.Controller;

import java.io.*;
import java.net.*;

public class Server {
    private int port;
    private ServerSocket serverSocket;

    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server is running on port " + port + "...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        String message = input.readLine();
        System.out.println("Client says: " + message);

        output.println("Hello from server!");

        socket.close();
        serverSocket.close();
    }
}