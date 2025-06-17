package com.example.bscs_3b_group_opina.server.Controller;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.io.*;
import java.net.*;

@Component
public class Server {
    private int port;
    private ServerSocket serverSocket;

    public Server() {
        this.port = 3000;
    }

    @PostConstruct // Runs after Spring Boot completes initialization
    public void start() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(port);
                System.out.println("Server is running on port " + port + "...");
                System.out.println("hello from server");

                while (true) { // Keep server running to accept multiple clients
                    Socket socket = serverSocket.accept();
                    System.out.println("Client connected!");

                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                    String message = input.readLine();
                    System.out.println("Client says: " + message);

                    output.println("Hello from server!");

                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start(); // Start server in a separate thread to avoid blocking Spring Boot
    }
}