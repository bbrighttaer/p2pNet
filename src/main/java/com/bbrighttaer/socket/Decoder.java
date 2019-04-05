package com.bbrighttaer.socket;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Decoder {

    private ObjectMapper mapper;

    public Decoder() {
        this.mapper = new ObjectMapper();
    }

    public <T extends Message> T decodeJsonString(String str, Class<T> clazz) throws IOException {
        return mapper.readValue(str, clazz);
    }

}
