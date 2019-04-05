package com.bbrighttaer.socket;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Decoder {

    /**
     * A mapper (from the Jackson library) to handle serialization operations.
     */
    private ObjectMapper mapper;

    public Decoder() {
        this.mapper = new ObjectMapper();
    }

    /**
     * Decodes a given string to a targeted class or type
     * @param str The string to be de-serialized
     * @param clazz Class object1
     * @param <T> The targeted class (e.g. {@link Message} class). The class should be {@link Message} or its subclass.
     * @return a Java object of the given string representation.
     * @throws IOException
     */
    public <T extends Message> T decodeJsonString(String str, Class<T> clazz) throws IOException {
        return mapper.readValue(str, clazz);
    }

}
