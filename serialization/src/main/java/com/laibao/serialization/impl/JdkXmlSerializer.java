package com.laibao.serialization.impl;

import com.laibao.serialization.ISerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author laibao wang
 * @date 2018-07-25
 * @version 1.0
 */
public class JdkXmlSerializer implements ISerializer{
    private Logger logger = LoggerFactory.getLogger(JdkXmlSerializer.class);

    public <T> byte[] serialize(T obj) {
        if (obj == null) {
            logger.error("obj is null");
            throw new IllegalArgumentException("obj is null");
        }
        try{
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            XMLEncoder encoder = new XMLEncoder(byteArrayOutputStream,"utf-8",true,0);
            encoder.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
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
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            XMLDecoder decoder = new XMLDecoder(byteArrayInputStream);
            T t = (T) decoder.readObject();
            byteArrayInputStream.close();
            return t;
        }catch (Exception ex) {
            logger.error("data deserialize failure!",ex.getMessage());
            throw new RuntimeException("data deserialize failure!",ex);
        }
    }
}
