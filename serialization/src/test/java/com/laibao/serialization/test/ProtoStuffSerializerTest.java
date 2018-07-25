package com.laibao.serialization.test;

import com.laibao.serialization.domain.User;
import com.laibao.serialization.impl.JackSonSerializer;
import com.laibao.serialization.impl.ProtoStuffSerializer;
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
public class ProtoStuffSerializerTest {

    @Test
    public void testProtoStuffSerializer() {
        User user = new User();
        user.setEmail("laibao_1@163.com");
        user.setName("laibao_1");

        User newUser = new User();
        newUser.setEmail("laibao_2@162.com");
        newUser.setName("laibao_2");

        List<User> userList = new ArrayList();
        Map<String, User> userMap = new HashMap();
        userList.add(newUser);
        userMap.put("user", newUser);

        user.setUserList(userList);
        user.setUserMap(userMap);


        byte[] userByte = new ProtoStuffSerializer().serialize(user);
        User user1 = new ProtoStuffSerializer().deserialize(userByte, User.class);
        System.out.println(user1.getEmail() + " : " + user1.getName() + " : " + new String(new JackSonSerializer().serialize(user1.getUserList())) + " : " + new String(new JackSonSerializer().serialize(user1.getUserMap())));
    }
}
