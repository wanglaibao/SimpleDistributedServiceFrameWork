package com.laibao.serialization;

/**
 * @author laibao wang
 * @date 2018-07-24
 * @version 1.0
 */
public interface ISerializer {

    /**
     * 对象序列化
     * @param obj
     * @param <T>
     * @return byte[]
     */
    <T> byte[] serialize(T obj);


    /**
     * 字节流反序列化
     * @param data
     * @param clazz
     * @param <T>
     * @return T
     */
    <T> T deserialize(byte[] data, Class<T> clazz);
}
