package com.laibao.serialization.test;

import com.laibao.serialization.domain.User;
import com.laibao.serialization.impl.XstreamSerializer;
import com.sun.xml.internal.txw2.output.XmlSerializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by A on 2018/7/25.
 */
public class XstreamSerializerTest {


    public void testXstreamSerializer() {

        User user = new User();
        user.setEmail("liyebing@163.com");
        user.setName("kongxuan");

        User newUser = new User();
        newUser.setEmail("liyebing@162.com");
        newUser.setName("kongxuan11");

        List<User> userList = new ArrayList<User>();
        Map<String, User> userMap = new HashMap<String, User>();
        userList.add(newUser);
        userMap.put("a", newUser);

        user.setUserList(userList);
        user.setUserMap(userMap);

        byte[] userByte = new XstreamSerializer().serialize(user);
        User user1 = new XstreamSerializer().deserialize(userByte, User.class);
        //System.out.println(user.getEmail() + " : " + user.getName() + " : " + new String(new JSONSerializer().serialize(user1.getUserList())) + " : " + new String(new JSONSerializer().serialize(u.getUserMap())));
    }
}
