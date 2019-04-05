package com.bbrighttaer.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Handles all connection operations of the in-Bound sub-component.
 * It implements the {@link Runnable} interface in order to lend itself for usage in a {@link Thread}.
 * This is necessary considering the possible use case of a node having to handle multiple in-bound requests/connections.
 */
public class ConnectionHandler implements Runnable {
    private final Socket socket;
    private final IMessageCallback callback;

    public ConnectionHandler(Socket socket, IMessageCallback callback) {
        this.socket = socket;
        this.callback = callback;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                callback.messageReceived(line);
            }
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
