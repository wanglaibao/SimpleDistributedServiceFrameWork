package com.laibao.serialization.test;

import com.laibao.serialization.domain.Person;
import com.laibao.serialization.domain.User;
import com.laibao.serialization.impl.JdkDefaultSerializer;
import com.laibao.serialization.impl.XstreamSerializer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author laibao wang
 * @date 2018-07-25
 * @version 1.0
 */
public class JdkDefaultSerializerTest {

    @Test
    public void testJdkDefaultSerializer() {
        Person person = new Person();
        person.setEmail("jinge_1@qq.com");
        person.setName("jinge_1");

        Person newPerson = new Person();
        newPerson.setEmail("jinge_2@qq.com");
        newPerson.setName("jinge_2");

        List<Person> personList = new ArrayList();
        Map<String, Person> personMap = new HashMap();
        personList.add(newPerson);
        personMap.put("person_a", newPerson);

        person.setPersonList(personList);
        person.setPersonMap(personMap);

        byte[] personByte = new JdkDefaultSerializer().serialize(person);
        System.out.println("personByte.toString(): "+ new String(personByte));

        Person person1 = new JdkDefaultSerializer().deserialize(personByte, null);
        System.out.println(person1.getEmail() + " : " + person1.getName()+" : "+person1.getPersonList() + " : "+person1.getPersonMap());
    }
}
