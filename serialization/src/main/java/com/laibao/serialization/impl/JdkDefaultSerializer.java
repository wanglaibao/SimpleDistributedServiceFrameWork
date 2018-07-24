package com.laibao.serialization.impl;

import com.laibao.serialization.ISerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author laibao wang
 * @date 2018-07-24
 * @version 1.0
 */
public class JdkDefaultSerializer implements ISerializer {

    public <T> byte[] serialize(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("obj is null");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
        }catch (Exception ex) {
            throw new RuntimeException("obj serialize failure!",ex);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) {
        if (data == null || clazz == null) {
            throw new IllegalArgumentException("argument error");
        }
        try{
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (T) objectInputStream.readObject();
        }catch (Exception ex){
            throw new RuntimeException("data deserialize failure!",ex);
        }
    }
}
