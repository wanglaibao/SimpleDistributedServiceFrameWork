package com.laibao.serialization.impl;

import com.laibao.serialization.ISerializer;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author laibao wang
 * @date 2018-07-25
 * @version 1.0.
 */
public class IOProtoStuffSerializer implements ISerializer{
    private Logger logger = LoggerFactory.getLogger(IOProtoStuffSerializer.class);

    private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<Class<?>, Schema<?>>();

    private static Objenesis objenesis = new ObjenesisStd(true);

    private static <T> Schema<T> getSchema(Class<T> clazz) {
        Schema<T> schema = (Schema<T>) cachedSchema.get(clazz);
        if (schema == null) {
            schema = RuntimeSchema.getSchema(clazz);
            cachedSchema.put(clazz, schema);
        }
        return schema;
    }


    public <T> byte[] serialize(T obj) {
        if (obj == null) {
            logger.error("obj is null");
            throw new IllegalArgumentException("obj is null");
        }
        try{
            //Class<T> clazz = (Class<T>) obj.getClass();
            LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
            Schema<T> schema = (Schema<T>) getSchema(obj.getClass());
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
            //T t = (T) objenesis.newInstance(clazz);
            Schema<T> schema = getSchema(clazz);
            T t = schema.newMessage();
            ProtostuffIOUtil.mergeFrom(data,t,schema);
            return t;
        }catch (Exception ex) {
            logger.error("data deserialize failure!",ex.getMessage());
            throw new RuntimeException("data deserialize failure!",ex);
        }
    }
}
