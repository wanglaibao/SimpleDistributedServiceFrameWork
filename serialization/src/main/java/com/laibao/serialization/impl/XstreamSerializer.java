package com.laibao.serialization.impl;

import com.laibao.serialization.ISerializer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author laibao wang
 * @date 2018-07-24
 * @version 1.0
 */
public class XstreamSerializer implements ISerializer{
    private Logger logger = LoggerFactory.getLogger(XstreamSerializer.class);

    private static final XStream xStream = new XStream(new DomDriver());

    public <T> byte[] serialize(T obj) {
        if(obj == null) {
            logger.error("obj is null");
            throw new IllegalArgumentException("obj is null");
        }
        try{
            return xStream.toXML(obj).getBytes();
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
            String xml = new String(data);
            return (T) xStream.fromXML(xml);
        }catch (Exception ex) {
            logger.error("data deserialize failure!",ex.getMessage());
            throw new RuntimeException("data deserialize failure!",ex);
        }
    }
}
