package com.laibao.springrpc.service.impl;

import com.laibao.springrpc.domain.User;
import com.laibao.springrpc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author laibao wang
 * @date 2018-07-26
 * @version 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    private static final Map<String, User> userMap = new HashMap<String, User>();

    static {
        userMap.put("jinge_1", new User("jinge_1", "jinge_1@163.com"));
        userMap.put("jinge_2", new User("jinge_2", "jinge_2@163.com"));
        userMap.put("jinge_3", new User("jinge_3", "jinge_3@163.com"));
        userMap.put("jinge_4", new User("jinge_4", "jinge_4@163.com"));
        userMap.put("jinge_5", new User("jinge_5", "jinge_5@163.com"));
        userMap.put("jinge_6", new User("jinge_6", "jinge_6@163.com"));
        userMap.put("jinge_7", new User("jinge_7", "jinge_7@163.com"));
        userMap.put("jinge_8", new User("jinge_8", "jinge_8@163.com"));
        userMap.put("jinge_9", new User("jinge_9", "jinge_9@163.com"));
        userMap.put("jinge_0", new User("jinge_0", "jinge_0@163.com"));
    }

    public User findUserByName(String userName) {
        logger.info("user name is : "+userName);
        return userMap.get(userName);
    }
}
