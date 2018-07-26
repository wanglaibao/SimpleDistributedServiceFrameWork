package com.laibao.serialization.domain;

import org.msgpack.annotation.Message;

import java.util.List;
import java.util.Map;

/**
 * @author laibao wang
 * @date 2018-07-26
 * @version 1.0
 */
@Message
public class Human {

    private String name;

    private String email;

    private List<Human> humanList;

    private Map<String, Human> humanMap;

    public Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }

    public Map<String, Human> getHumanMap() {
        return humanMap;
    }

    public void setHumanMap(Map<String, Human> humanMap) {
        this.humanMap = humanMap;
    }
}
