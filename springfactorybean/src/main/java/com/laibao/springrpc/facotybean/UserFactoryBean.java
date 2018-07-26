package com.laibao.springrpc.facotybean;

import com.laibao.springrpc.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author laibao wang
 * @date 2018-07-26
 * @version 1.0
 */
public class UserFactoryBean implements FactoryBean<User>{

    private String name;

    private String email;

    public User getObject() throws Exception {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return user;
    }

    public Class<?> getObjectType() {
        return User.class;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
