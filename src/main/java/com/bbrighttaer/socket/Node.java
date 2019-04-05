package com.bbrighttaer.socket;

import java.io.IOException;

/**
 * A node in a peer to peer network.
 * It composes two main sub-components: inBound and outBound.
 * It also implements the message callback interface to enable notification of incoming messages.
 */
public class Node implements IMessageCallback {
    /**
     * The inBound sub-component
     */
    private InBound inBound;

    /**
     * The outBound sub-component
     */
    private OutBound outBound;

    /**
     * The identification of a node in the network
     */
    private final String nodeId;

    /**
     * The port for listening for in-coming messages
     */
    private final int inBoundPort;

    /**
     * Instantiates a node object
     * @param inBoundPort The listening port
     * @param nodeId The identity of the node
     */
    public Node(int inBoundPort, String nodeId) {
        this.inBound = new InBound(inBoundPort, this);
        this.outBound = new OutBound();
        this.nodeId = nodeId;
        this.inBoundPort = inBoundPort;
    }

    /**
     * Puts the node in online mode.
     */
    public void start() {
        this.inBound.open();
    }

    /**
     * Puts the node in an offline mode
     */
    public void stop() {
        this.inBound.setIsOnline(false);
    }

    /**
     * Sends a message to a destination
     * @param msg The message to be sent
     * @param dest_addr The destination address (e.g. IPv4 address)
     * @param port The destination port number
     */
    public void sendMessage(Message msg, String dest_addr, int port) {
        System.out.println(nodeId + " is sending message to " + msg.getDestinationId());
        this.outBound.send(dest_addr, port, msg);
    }

    /**
     * Gets the ID of the node
     * @return The node ID
     */
    public String getNodeId() {
        return nodeId;
    }

    /**
     * Gets the listening port number
     * @return The port number
     */
    public int getInBoundPort() {
        return inBoundPort;
    }

    @Override
    public void messageReceived(String msg) {
        Message m = null;
        try {
            m = new Decoder().decodeJsonString(msg, Message.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(m != null) {
            System.out.println(nodeId + " has received a msg: " + m.toString());
        }
    }
}
