package com.laibao.serialization.test;

import com.laibao.serialization.domain.Human;
import com.laibao.serialization.domain.User;
import com.laibao.serialization.impl.FastJsonSerializer;
import com.laibao.serialization.impl.MessagePackSerializer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author laibao wang
 * @date 2018-07-26
 * @version 1.0
 *
 */
public class MessagePackSerializerTest {

    @Test
    public void testMessagePackSerializer() {
        Human human = new Human();
        human.setEmail("jinge_1@163.com");
        human.setName("jinge_1");

        Human newHuman = new Human();
        newHuman.setEmail("jinge_2@162.com");
        newHuman.setName("jinge_2");

        List<Human> humanList = new ArrayList();
        Map<String, Human> humanMap = new HashMap();
        humanList.add(newHuman);
        humanMap.put("human", newHuman);

        human.setHumanList(humanList);
        human.setHumanMap(humanMap);


        byte[] humanByte = new MessagePackSerializer().serialize(human);
        Human human1 = new MessagePackSerializer().deserialize(humanByte, Human.class);
        System.out.println(human1.getEmail() + " : " + human1.getName() + " : " + new String(new FastJsonSerializer().serialize(human1.getHumanList())) + " : " + new String(new FastJsonSerializer().serialize(human1.getHumanMap())));

    }
}
