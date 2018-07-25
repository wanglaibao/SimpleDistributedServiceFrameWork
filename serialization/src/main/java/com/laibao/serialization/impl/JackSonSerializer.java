package com.laibao.serialization.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.laibao.serialization.ISerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author laibao wang
 * @date 2018-07-25
 * @version 1.0
 */
public class JackSonSerializer implements ISerializer{
    private Logger logger = LoggerFactory.getLogger(JackSonSerializer.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        //SimpleModule module = new SimpleModule("DateTimeModule", Version.unknownVersion());
        //module.addSerializer(Date.class, new FDateJsonSerializer());
        //module.addDeserializer(Date.class, new FDateJsonDeserializer());
        //objectMapper.registerModule(module);
    }

    private static ObjectMapper getObjectMapperInstance() {
        return objectMapper;
    }

    public <T> byte[] serialize(T obj) {
        return new byte[0];
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return null;
    }
}
