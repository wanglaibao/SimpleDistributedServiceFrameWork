package com.laibao.serialization.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author laibao wang
 * @date 2018-07-25
 * @version 1.0
 */
public class Person implements Serializable{
    private static final long serialVersionUID = 7223192274424508219L;

    private String name;

    private String email;

    private List<Person> personList;

    private Map<String, Person> personMap;

    public Person() {
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

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Map<String, Person> getPersonMap() {
        return personMap;
    }

    public void setPersonMap(Map<String, Person> personMap) {
        this.personMap = personMap;
    }
}
