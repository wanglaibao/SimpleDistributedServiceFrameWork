package com.laibao.userdefinedxmltag.test;

import com.laibao.userdefinedxmltag.domain.People;
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
    public void testPersonBeanDefinitionXmlTag() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("META-INF/spring/person.xml");
        applicationContext.refresh();
        Person person = applicationContext.getBean("jinge",Person.class);
        System.out.println("name: " + person.getName() + " age: " + person.getAge() + " address: "+ person.getAddress());
    }

    @Test
    public void testPeopleBeanDefinitionXmlTag() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("META-INF/spring/people.xml");
        applicationContext.refresh();

        People people = applicationContext.getBean("jinge",People.class);
        System.out.println("name: " + people.getName() + " age: " + people.getAge() + " id: "+ people.getId());
    }
}
