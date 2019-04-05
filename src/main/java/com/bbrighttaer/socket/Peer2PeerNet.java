package com.bbrighttaer.socket;

import java.util.ArrayList;
import java.util.List;

public class Peer2PeerNet {
    private static final List<Integer> ASSIGNED_PORTS = new ArrayList();

    public static void main(String[] args) throws InterruptedException {
        Node node1 = new Node(selectPortNumber(), "node1");
        Node node2 = new Node(selectPortNumber(), "node2");
        Node node3 = new Node(selectPortNumber(), "node3");

        //start nodes
        new Thread(node1::start).start();
        new Thread(node2::start).start();
        new Thread(node3::start).start();

        //wait for network to be ready
        Thread.sleep(1000);

        //send message
        node1.sendMessage(new Message(node1.getNodeId(), node2.getNodeId(), "Hello my peer - from node1"),
                "127.0.0.1", node2.getInBoundPort());
        node2.sendMessage(new Message(node2.getNodeId(), node1.getNodeId(), "Hello my peer - from node2"),
                "127.0.0.1", node1.getInBoundPort());
        node1.sendMessage(new Message(node1.getNodeId(), node3.getNodeId(), "Hello my peer - from node1"),
                "127.0.0.1", node3.getInBoundPort());
        node3.sendMessage(new Message(node3.getNodeId(), node2.getNodeId(), "Hello my peer - from node3"),
                "127.0.0.1", node2.getInBoundPort());

        while (true) ;

    }

    /**
     * Gets a port number within the range 49152 to 65532
     *
     * @return Port number
     */
    public static int selectPortNumber() {
        int portNumber; //range is from 49152 -> 65532
        do {
            portNumber = 49152 + (int) (Math.random() * 16381);
        } while (ASSIGNED_PORTS.contains(portNumber));
        ASSIGNED_PORTS.add(portNumber);
        return portNumber;
    }
}
