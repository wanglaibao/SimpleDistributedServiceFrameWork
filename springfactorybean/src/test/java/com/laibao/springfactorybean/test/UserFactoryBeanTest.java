package com.laibao.springfactorybean.test;

import com.alibaba.fastjson.JSON;
import com.laibao.springrpc.domain.Person;
import com.laibao.springrpc.domain.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author laibao wang
 * @date 2018-07-26
 * @version 1.0
 */
public class UserFactoryBeanTest {

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
}
