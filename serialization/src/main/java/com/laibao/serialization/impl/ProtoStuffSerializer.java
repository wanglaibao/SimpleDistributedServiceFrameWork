package com.laibao.serialization.impl;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.laibao.serialization.ISerializer;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author laibao wang
 * @date 2018-07-25
 * @version 1.0
 */
public class ProtoStuffSerializer implements ISerializer{
    private Logger logger = LoggerFactory.getLogger(ProtoStuffSerializer.class);

    private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<Class<?>, Schema<?>>();

    private static Objenesis objenesis = new ObjenesisStd(true);

    private static <T> Schema<T> getSchema(Class<T> cls) {
        Schema<T> schema = (Schema<T>) cachedSchema.get(cls);
        if (schema == null) {
            schema = RuntimeSchema.createFrom(cls);
            cachedSchema.put(cls, schema);
        }
        return schema;
    }


    public <T> byte[] serialize(T obj) {
        if (obj == null) {
            logger.error("obj is null");
            throw new IllegalArgumentException("obj is null");
        }
        try{
            Class<T> cls = (Class<T>) obj.getClass();
            LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
            Schema<T> schema = getSchema(cls);
            byte[] byteArray = ProtostuffIOUtil.toByteArray(obj, schema, buffer);
            buffer.clear();
            return byteArray;
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
            T message = (T) objenesis.newInstance(clazz);
            Schema<T> schema = getSchema(clazz);
            ProtostuffIOUtil.mergeFrom(data, message, schema);
            return message;
        }catch (Exception ex) {
            logger.error("data deserialize failure!",ex.getMessage());
            throw new RuntimeException("data deserialize failure!",ex);
        }
    }
}
