package com.bbrighttaer.socket;

import java.io.IOException;

public class Node implements IMessageCallback {
    private InBound inBound;
    private OutBound outBound;
    private final String nodeId;
    private final int inBoundPort;

    public Node(int inBoundPort, String nodeId) {
        this.inBound = new InBound(inBoundPort, this);
        this.outBound = new OutBound();
        this.nodeId = nodeId;
        this.inBoundPort = inBoundPort;
    }

    public void start() {
        this.inBound.open();
    }

    public void stop() {
        this.inBound.setIsOnline(false);
    }

    public void sendMessage(Message msg, String host, int port) {
        System.out.println(nodeId + " is sending message to " + msg.getDestinationId());
        this.outBound.send(host, port, msg);
    }

    public String getNodeId() {
        return nodeId;
    }

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
