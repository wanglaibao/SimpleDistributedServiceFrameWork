package com.laibao.springfactorybean.test;

import com.alibaba.fastjson.JSON;
import com.laibao.springrpc.domain.Car;
import com.laibao.springrpc.domain.Employee;
import com.laibao.springrpc.domain.Person;
import com.laibao.springrpc.domain.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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

    @Test
    public void testMySqlConnectionProxyFactoryBean() {
        try {
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
            applicationContext.setConfigLocation("META-INF/spring/factorybean.xml");
            applicationContext.refresh();
            // Get mysql connection object.
            Connection mysqlConn = applicationContext.getBean("mysqlDBConnection",Connection.class);
            String mysqldbProductName = mysqlConn.getMetaData().getDatabaseProductName();
            String mysqldbProductVersion = mysqlConn.getMetaData().getDatabaseProductVersion();
            System.out.println("mysqldbProductName = " + mysqldbProductName + " , mysqldbProductVersion = " + mysqldbProductVersion);
            applicationContext.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }

    }

    @Test
    public void testMySqlConnectio() throws Exception {
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://XXXXX:3306/test";
        //  Database credentials
        final String USER = "dev";
        final String PASS = "JlDV94BW!";
        Connection conn = null;
        Statement stmt = null;
        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        stmt = conn.createStatement();
    }
}
