package com.laibao.serialization.test;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.laibao.serialization.domain.Person;
import com.laibao.serialization.domain.User;
import com.laibao.serialization.impl.FastJsonSerializer;
import com.laibao.serialization.impl.JbossMarshallingSerializer;
import org.junit.Test;

/**
 * @author laibao wang
 * @date 2018-07-26
 * @version 1.0
 */
public class JbossMarshallingSerializerTest {

    @Test
    public void testJbossMarshallingSerializer() {
        Person person = new Person();
        person.setEmail("jinge_1@163.com");
        person.setName("jinge_1");

        byte[] personByte = new JbossMarshallingSerializer().serialize(person);
        Person person1 = new JbossMarshallingSerializer().deserialize(personByte, Person.class);
        //System.out.println(person1.getEmail() + " : " + person1.getName() + " : " + new String(new FastJsonSerializer().serialize(person1.getPersonList())) + " : " + new String(new FastJsonSerializer().serialize(person1.getPersonMap())));
        System.out.println(person1.getEmail() + " : " + person1.getName());
    }
}
