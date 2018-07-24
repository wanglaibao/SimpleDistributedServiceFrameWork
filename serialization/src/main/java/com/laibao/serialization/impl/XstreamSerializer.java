package com.laibao.serialization.impl;

import com.laibao.serialization.ISerializer;

/**
 * @author laibao wang
 * @date 2018-07-24
 * @version 1.0
 */
public class XstreamSerializer implements ISerializer{

    public <T> byte[] serialize(T obj) {
        return new byte[0];
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return null;
    }
}
