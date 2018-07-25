package com.laibao.serialization.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.laibao.serialization.ISerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author laibao wang
 * @date 2018-07-25
 * @version 1.0
 */
public class FastJsonSerializer implements ISerializer{
    private Logger logger = LoggerFactory.getLogger(FastJsonSerializer.class);

    public <T> byte[] serialize(T obj) {
        if (obj == null) {
            logger.error("obj is null");
            throw new IllegalArgumentException("obj is null");
        }
        try{
            JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
            return JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat).getBytes();
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
            T t = JSON.parseObject(new String(data),clazz);
            return t;
        }catch (Exception ex) {
            logger.error("data deserialize failure!",ex.getMessage());
            throw new RuntimeException("data deserialize failure!",ex);
        }
    }
}
