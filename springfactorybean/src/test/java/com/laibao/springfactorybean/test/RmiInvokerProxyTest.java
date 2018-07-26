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
public class RmiInvokerProxyTest {

    @Test
    public void testRmiInvoker(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocations(new String[]{"META-INF/spring/rmi-rpc-server.xml",
                                                            "META-INF/spring/rmi-rpc-client.xml"});
        applicationContext.refresh();

        //RMI 要求Bean对象必须实现Serializable接口
        UserService userService = (UserService) applicationContext.getBean("userRmiServiceProxy");
        User user = userService.findUserByName("jinge_1");
        System.out.println(JSON.toJSONString(user));
    }

}
