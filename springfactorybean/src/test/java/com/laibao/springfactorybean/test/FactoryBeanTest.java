package com.laibao.springfactorybean.test;

import com.alibaba.fastjson.JSON;
import com.laibao.springrpc.domain.Car;
import com.laibao.springrpc.domain.Employee;
import com.laibao.springrpc.domain.Person;
import com.laibao.springrpc.domain.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author laibao wang
 * @date 2018-07-26
 * @version 1.0
 */
public class FactoryBeanTest {

    @Test
    public void testUserFactoryBean() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/beans.xml");
        User user = applicationContext.getBean("user",User.class);
        Person person = applicationContext.getBean("person",Person.class);
        applicationContext.close();
        System.out.println(JSON.toJSONString(user));
        System.out.println();
        System.out.println(JSON.toJSONString(person));
    }

    @Test
    public void testCarFactoryBean() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/factorybean.xml");
        Car car = applicationContext.getBean("carFactoryBean",Car.class);
        System.out.println(JSON.toJSONString(car));
        applicationContext.close();
    }

    @Test
    public void testEmployeeFactoryBean() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("META-INF/spring/factorybean.xml");
        applicationContext.refresh();

        Employee manager = applicationContext.getBean("manager", Employee.class);
        System.out.println(JSON.toJSONString(manager));

        System.out.println();

        Employee director =  applicationContext.getBean("director",Employee.class);
        System.out.println(JSON.toJSONString(director));;
        applicationContext.close();
    }
}
