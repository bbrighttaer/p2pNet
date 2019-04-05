package com.bbrighttaer.socket;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Sub-module to be composed in a Node object for handling out-going message operations
 */
public class OutBound {

    /**
     * Sends a message to a target node.
     * An encoder is used to encode the message into a string object. This enables a straightforward conversion to bytes
     * for transmission in the network.
     *
     * @param dest_addr The address of the targeted node
     * @param port      The port number of the targeted node
     * @param message   The message to be delivered
     */
    public void send(String dest_addr, int port, Message message) {
        try (Socket socket = new Socket(dest_addr, port)) {
            BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println(new Encoder().enc2String(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
