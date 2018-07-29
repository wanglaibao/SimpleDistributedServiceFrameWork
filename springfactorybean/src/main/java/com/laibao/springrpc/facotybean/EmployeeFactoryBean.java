package com.laibao.springrpc.facotybean;

import com.laibao.springrpc.domain.Employee;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * @author laibao wang
 * @date 2018-07-30
 * @version 1.0
 */
public class EmployeeFactoryBean extends AbstractFactoryBean<Employee>{

    private int id;

    private String firstName;

    private String lastName;

    private String designation;

    private Employee employee;

    public Class<?> getObjectType() {
        return Employee.class;
    }

    //This method will be called by container to create new instances
    public Employee createInstance() throws Exception {
        employee = new Employee();
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setDesignation(designation);
        return employee;
    }

//    @Override
//    不可以用在这里，目前我还没有找到原因
//    public void afterPropertiesSet() throws Exception {
//        super.afterPropertiesSet();
//        employee = new Employee();
//        employee.setId(id);
//        employee.setFirstName(firstName);
//        employee.setLastName(lastName);
//        employee.setDesignation(designation);
//    }

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
