package com.bbrighttaer.socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Encodes a message
 */
public class Encoder {

    /**
     * A mapper (from the Jackson library) to handle serialization operations.
     */
    private ObjectMapper mapper;

    public Encoder() {
        this.mapper = new ObjectMapper();
    }

    /**
     * Encodes a given message/object into a string object
     * @param o The object to be serialized.
     * @return A string representation of the message.
     * @throws JsonProcessingException
     */
    public String enc2String(Object o) throws JsonProcessingException {
        return mapper.writeValueAsString(o);
    }

}
