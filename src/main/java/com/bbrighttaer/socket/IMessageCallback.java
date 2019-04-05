package com.bbrighttaer.socket;

/**
 * Interface for facilitating notification of received messages in the in-Bound sub-component of a node.
 */
public interface IMessageCallback {
    /**
     * The call back function for received messages.
     * A default implementation is provided but can be customized upon implementation.
     * @param msg The received message
     */
    default void messageReceived(String msg){
        System.out.println("Received: "+msg);
    }
}
