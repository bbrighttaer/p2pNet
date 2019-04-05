package com.bbrighttaer.socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Encoder {

    private ObjectMapper mapper;

    public Encoder() {
        this.mapper = new ObjectMapper();
    }

    public String enc2String(Object o) throws JsonProcessingException {
        return mapper.writeValueAsString(o);
    }

}
