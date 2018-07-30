package com.laibao.springrpc.configuration;

import com.laibao.springrpc.domain.Car;
import com.laibao.springrpc.domain.Employee;
import com.laibao.springrpc.facotybean.CarFactoryBean;
import com.laibao.springrpc.facotybean.EmployeeFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author laibao wang
 * @date 2018-07-30
 * @version 1.0
 */
@Configuration
public class FactoryBeanConfig {

    @Bean(name = "carFactoryBean")
    public CarFactoryBean carFactoryBean() {
        CarFactoryBean carFactoryBean = new CarFactoryBean();
        carFactoryBean.setBrand("宝马");
        carFactoryBean.setMaker("德国");
        carFactoryBean.setYear(1990);
        return carFactoryBean;
    }

    @Bean(name = "managerFactoryBean")
    public EmployeeFactoryBean managerFactoryBean() {
        EmployeeFactoryBean employeeFactoryBean = new EmployeeFactoryBean();
        employeeFactoryBean.setId(1000);
        employeeFactoryBean.setFirstName("马");
        employeeFactoryBean.setLastName("德怀");
        employeeFactoryBean.setDesignation("总经理");
        return employeeFactoryBean;
    }

    @Bean
    public Car car() throws Exception {
        return carFactoryBean().getObject();
    }

    @Bean
    public Employee manager() throws Exception {
        return managerFactoryBean().getObject();
    }
}
