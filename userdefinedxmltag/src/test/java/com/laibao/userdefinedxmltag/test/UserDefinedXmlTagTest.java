package com.laibao.userdefinedxmltag.test;

import com.laibao.userdefinedxmltag.domain.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author laibao wang
 * @date 2018-07-27
 * @version 1.0
 */
public class UserDefinedXmlTagTest {

    @Test
    public void testUserDefinedXmlTag() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("META-INF/spring/person.xml");
        applicationContext.refresh();
        Person person = applicationContext.getBean("jinge",Person.class);
        System.out.println("name: " + person.getName() + " age: " + person.getAge() + " address: "+ person.getAddress());
    }
}
