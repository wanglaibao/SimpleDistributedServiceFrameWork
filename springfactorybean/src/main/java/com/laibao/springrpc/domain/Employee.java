package com.laibao.springrpc.domain;

/**
 * @author laibao wang
 * @date 2018-07-30
 * @version 1.0
 */
public class Employee {
    private int id;

    private String firstName;

    private String lastName;

    private String designation;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
