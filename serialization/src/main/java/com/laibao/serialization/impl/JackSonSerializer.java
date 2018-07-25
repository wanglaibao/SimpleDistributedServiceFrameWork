package com.laibao.serialization.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.laibao.serialization.DateJsonDeserializer;
import com.laibao.serialization.DateJsonSerializer;
import com.laibao.serialization.ISerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;

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

        SimpleModule module = new SimpleModule("DateTimeModule", Version.unknownVersion());
        module.addSerializer(Date.class, new DateJsonSerializer());
        module.addDeserializer(Date.class, new DateJsonDeserializer());
        objectMapper.registerModule(module);
    }

    private static ObjectMapper getObjectMapperInstance() {
        return objectMapper;
    }

    public <T> byte[] serialize(T obj) {
        if (obj == null) {
            logger.error("obj is null");
            throw new IllegalArgumentException("obj is null");
        }
        try{
            String json = objectMapper.writeValueAsString(obj);
            return json.getBytes();
        }catch (Exception ex) {
            logger.error("obj serialize failure!",ex.getMessage());
            throw new RuntimeException("obj serialize failure!",ex);
        }
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) {
        if (data == null) {
            logger.error("argument error");
            throw new IllegalArgumentException("argument error");
        }
        try {
            String jsonStr = new String(data);
            T t = objectMapper.readValue(jsonStr,clazz);
            return t;
        }catch (Exception ex) {
            logger.error("data deserialize failure!",ex.getMessage());
            throw new RuntimeException("data deserialize failure!",ex);
        }
    }
}
