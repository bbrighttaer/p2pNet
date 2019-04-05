package com.bbrighttaer.socket;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A Plain Old Java Object (POJO) for facilitating serializing and de-serializing a message object.
 */
@XmlRootElement
public class Message {
    /**
     * The ID of the originator of the message
     */
    private String senderId;

    /**
     * The ID of the intended recipient
     */
    private String destinationId;

    /**
     * The actual message to be delivered
     */
    private Object message;

    /**
     * No-argument constructor required for serialization and deserialization operations
     */
    public Message() {
    }


    /**
     * Creates a message object
     * @param senderId The originating node's ID
     * @param destinationId The destination node's ID
     * @param message The message content
     */
    public Message(String senderId, String destinationId, Object message) {
        this.senderId = senderId;
        this.destinationId = destinationId;
        this.message = message;
    }

    /**
     * Gets the sending node's ID
     * @return
     */
    public String getSenderId() {
        return senderId;
    }

    /**
     * Gets the message object
     * @return The message
     */
    public Object getMessage() {
        return message;
    }

    /**
     * The node ID of the receiver
     * @return Node ID
     */
    public String getDestinationId() {
        return destinationId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "senderId='" + senderId + '\'' +
                ", destinationId='" + destinationId + '\'' +
                ", message=" + message +
                '}';
    }
}
