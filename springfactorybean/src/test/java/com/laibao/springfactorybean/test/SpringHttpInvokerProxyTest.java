package com.laibao.springfactorybean.test;

import com.alibaba.fastjson.JSON;
import com.laibao.springrpc.domain.User;
import com.laibao.springrpc.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author laibao wang
 * @date 2018-07-26
 * @version 1.0
 */
public class SpringHttpInvokerProxyTest {

    @Test
    public void testSpringHttpInvokerProxy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("META-INF/spring/httpinvoker-rpc-client.xml");
        applicationContext.refresh();

        UserService userService = (UserService) applicationContext.getBean("userServiceProxy");
        User user = userService.findUserByName("jinge_2");
        System.out.println(JSON.toJSONString(user));
    }
}
