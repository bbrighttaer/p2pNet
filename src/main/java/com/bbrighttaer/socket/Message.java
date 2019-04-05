package com.bbrighttaer.socket;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
    private String senderId;
    private String destinationId;
    private Object message;

    public Message() {
    }

    public Message(String senderId, String destinationId, Object message) {
        this.senderId = senderId;
        this.destinationId = destinationId;
        this.message = message;
    }

    public String getSenderId() {
        return senderId;
    }

    public Object getMessage() {
        return message;
    }

    public String getDestinationId() {
        return destinationId;
    }
}
