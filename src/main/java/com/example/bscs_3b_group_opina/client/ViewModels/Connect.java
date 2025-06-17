package com.example.bscs_3b_group_opina.client.ViewModels;

import java.io.*;
import java.net.*;

public class Connect {
    private Socket socket;
    private PrintWriter output;
    private BufferedReader input;

    public Connect(String host, int port) throws IOException {
        socket = new Socket(host, port);
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void sendMessage(String message) {
        output.println(message);
    }

    public String receiveMessage() throws IOException {
        return input.readLine();
    }

    public void close() throws IOException {
        input.close();
        output.close();
        socket.close();
    }
}