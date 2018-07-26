package com.laibao.springrpc.service;

import com.laibao.springrpc.domain.User;

/**
 * @author laibao wang
 * @date 2018-07-26
 * @version 1.0
 */
public interface UserService {

    /**
     *
     * @param userName
     * @return User
     */
    User findUserByName(String userName);
}
