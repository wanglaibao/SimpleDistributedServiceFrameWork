package com.laibao.serialization.test;

import com.laibao.serialization.domain.User;
import com.laibao.serialization.impl.XstreamSerializer;
import com.sun.xml.internal.txw2.output.XmlSerializer;
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
public class XstreamSerializerTest {

    @Test
    public void testXstreamSerializer() {
        User user = new User();
        user.setEmail("jinge_1@qq.com");
        user.setName("jinge_1");

        User newUser = new User();
        newUser.setEmail("jinge_2@qq.com");
        newUser.setName("jinge_2");

        List<User> userList = new ArrayList();
        Map<String, User> userMap = new HashMap();
        userList.add(newUser);
        userMap.put("user_a", newUser);

        user.setUserList(userList);
        user.setUserMap(userMap);

        byte[] userByte = new XstreamSerializer().serialize(user);
        System.out.println(userByte);

        User user1 = new XstreamSerializer().deserialize(userByte, null);
        System.out.println(user1.getEmail() + " : " + user1.getName()+" : "+user.getUserList() + " : "+user1.getUserMap());
    }
}
