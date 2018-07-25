package com.laibao.serialization.test;

import com.laibao.serialization.domain.Person;
import com.laibao.serialization.impl.FastJsonSerializer;
import com.laibao.serialization.impl.HessianSerializer;
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
public class HessianSerializerTest{

    @Test
    public void testHessianSerializer() {
        Person person = new Person();
        person.setEmail("jinge_1@163.com");
        person.setName("jinge_1");

        Person newPerson = new Person();
        newPerson.setEmail("jinge_2@162.com");
        newPerson.setName("jinge_2");

        List<Person> personList = new ArrayList();
        Map<String, Person> personMap = new HashMap();
        personList.add(newPerson);
        personMap.put("person", newPerson);

        person.setPersonList(personList);
        person.setPersonMap(personMap);

        byte[] personByte = new HessianSerializer().serialize(person);
        Person person1 = new HessianSerializer().deserialize(personByte, Person.class);
        System.out.println(person1.getEmail() + " : " + person1.getName() + " : " + new String(new FastJsonSerializer().serialize(person1.getPersonList())) + " : " + new String(new FastJsonSerializer().serialize(person1.getPersonMap())));
    }
}
