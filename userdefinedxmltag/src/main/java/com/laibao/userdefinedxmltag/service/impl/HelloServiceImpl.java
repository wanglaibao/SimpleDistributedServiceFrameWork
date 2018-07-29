package com.laibao.userdefinedxmltag.service.impl;

import com.laibao.userdefinedxmltag.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author laibao wang
 * @date 2018-07-28
 * @version 1.0
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {

    public String sayHelloMessage(String msg) {
        return "Hello, "+msg;
    }
}
