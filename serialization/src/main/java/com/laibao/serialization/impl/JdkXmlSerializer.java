package com.laibao.serialization.impl;

import com.laibao.serialization.ISerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author laibao wang
 * @date 2018-07-25
 * @version 1.0
 */
public class JdkXmlSerializer implements ISerializer{
    private Logger logger = LoggerFactory.getLogger(JdkXmlSerializer.class);


    public <T> byte[] serialize(T obj) {
        return new byte[0];
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return null;
    }
}
