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
public class HessianInvokerProxyTest {

    @Test
    public void testHessianInvokerProxy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("META-INF/spring/hessian-rpc-client.xml");
        applicationContext.refresh();
        UserService userService = applicationContext.getBean("userServiceHessianProxy",UserService.class);
        User user = userService.findUserByName("jinge_3");
        System.out.println(JSON.toJSONString(user));

    }
}
