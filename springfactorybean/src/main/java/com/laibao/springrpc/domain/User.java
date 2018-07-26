package com.laibao.springrpc.domain;

/**
 * @author laibao wang
 * @date 2018-07-26
 * @version 1.0
 */
public class User {

    private String name;

    private String email;

    public User() {
    }

    public User(String name,String email) {
        this.name = name;
        this.email = email;
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
}
