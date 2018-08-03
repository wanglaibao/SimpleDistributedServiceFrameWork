package com.laibao.springrpc.facotybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.security.MessageDigest;

/**
 * @author laibao wang
 * @date 2018-08-03
 * @version 1.0
 */
public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>,InitializingBean {

    private String algorithmName = "MD5";

    private MessageDigest messageDigest;

    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    public Class<?> getObjectType() {
        return MessageDigest.class;
    }

    public void afterPropertiesSet() throws Exception {
        messageDigest = MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
