package com.laibao.serialization.impl;

import com.laibao.serialization.ISerializer;
import org.msgpack.MessagePack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author laibao wang
 * @date 2018-07-26
 * @version 1.0
 */
public class MessagePackSerializer implements ISerializer{
    private Logger logger = LoggerFactory.getLogger(MessagePackSerializer.class);

    public <T> byte[] serialize(T obj) {
        if (obj == null) {
            logger.error("obj is null");
            throw new IllegalArgumentException("obj is null");
        }
        try{
            MessagePack messagePack = new MessagePack();
            // if target class does not annotated by @Message to use below statement
            // messagePack.register(obj.getClass());
            return messagePack.write(obj);
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
        try{
            MessagePack messagePack = new MessagePack();
            // if target class does not annotated by @Message to use below statement
            // messagePack.register(clazz);
            return (T) messagePack.read(data, clazz);
        }catch (Exception ex) {
            logger.error("data deserialize failure!",ex.getMessage());
            throw new RuntimeException("data deserialize failure!",ex);
        }
    }
}
