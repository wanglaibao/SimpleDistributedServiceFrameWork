package com.laibao.springrpc.domain;

/**
 * @author laibao wang
 * @date 2018-07-26
 * @version 1.0
 */
public class Person {
    private String name;

    private String address;

    private int age;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
