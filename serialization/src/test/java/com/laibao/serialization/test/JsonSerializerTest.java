package com.laibao.serialization.test;

import com.laibao.serialization.domain.User;
import com.laibao.serialization.impl.FastJsonSerializer;
import com.laibao.serialization.impl.JackSonSerializer;
import org.junit.Test;

/**
 * @author laibao wang
 * @date 2018-07-25
 * @version 1.0
 */
public class JsonSerializerTest {

    @Test
    public void testFastJsonSerializer() {
        User user = new User();
        user.setEmail("jinge@qq.com");
        user.setName("jinge");

        FastJsonSerializer fastJsonSerializer = new FastJsonSerializer();
        byte[] bytes = fastJsonSerializer.serialize(user);

        User newUser = fastJsonSerializer.deserialize(bytes, User.class);
        System.out.println("newUser : " + newUser.getName() + " : "+ newUser.getEmail());
    }

    @Test
    public void testJackSonSerializer() {
        User user = new User();
        user.setEmail("jinge_111@qq.com");
        user.setName("jinge_111");

        JackSonSerializer jackSonSerializer = new JackSonSerializer();
        byte[] bytes = jackSonSerializer.serialize(user);

        User newUser = jackSonSerializer.deserialize(bytes, User.class);
        System.out.println("newUser : " + newUser.getName() + " : "+ newUser.getEmail());
    }
}
