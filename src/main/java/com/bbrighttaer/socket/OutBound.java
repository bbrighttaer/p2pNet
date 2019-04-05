package com.bbrighttaer.socket;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class OutBound {
    private ObjectMapper mapper;

    public OutBound() {
        this.mapper = new ObjectMapper();
    }

    public void send(String host, int port, Message message) {
        try (Socket socket = new Socket(host, port)) {
            BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println(mapper.writeValueAsString(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
