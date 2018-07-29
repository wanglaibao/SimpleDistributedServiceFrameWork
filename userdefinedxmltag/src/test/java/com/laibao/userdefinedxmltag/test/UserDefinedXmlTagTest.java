package com.laibao.userdefinedxmltag.test;

import com.alibaba.fastjson.JSON;
import com.laibao.userdefinedxmltag.domain.*;
import com.laibao.userdefinedxmltag.service.HelloService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author laibao wang
 * @date 2018-07-27
 * @version 1.0
 */
public class UserDefinedXmlTagTest {

    @Test
    public void testPersonBeanDefinitionXmlTag() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("META-INF/spring/person.xml");
        applicationContext.refresh();
        Person person = applicationContext.getBean("jinge",Person.class);
        System.out.println("name: " + person.getName() + " age: " + person.getAge() + " address: "+ person.getAddress());
        applicationContext.close();
    }

    @Test
    public void testPeopleBeanDefinitionXmlTag() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("META-INF/spring/people.xml");
        applicationContext.refresh();
        People people = applicationContext.getBean("jinge",People.class);
        System.out.println("name: " + people.getName() + " age: " + people.getAge() + " id: "+ people.getId());
        applicationContext.close();
    }

    @Test
    public void testDataSourceBeanDefinitionXmlTag() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("META-INF/spring/datasource.xml");
        applicationContext.refresh();
        DataSource dataSource = applicationContext.getBean("dataSource",DataSource.class);
        System.out.println(JSON.toJSONString(dataSource));
        applicationContext.close();
    }

    @Test
    public void testMinaComplexTypeBeanDefinitionXmlTag() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("META-INF/spring/mina.xml");
        applicationContext.refresh();

        HelloService helloService = applicationContext.getBean("helloService",HelloService.class);
        System.out.println(helloService.sayHelloMessage("金戈"));

        ServiceBean serviceBean = applicationContext.getBean("rpcService",ServiceBean.class);
        System.out.println("rpcServiceBean:"+serviceBean.getInterfaceName());

        ReferenceBean referenceBean = applicationContext.getBean("personService",ReferenceBean.class);
        System.out.println("referenceBean:"+referenceBean.getInterfaceName());

        RegistryBean registryBean = applicationContext.getBean("zk",RegistryBean.class);
        System.out.println("registryBean:"+registryBean.getAddress());

        ProtocolBean protocolBean = applicationContext.getBean("hessian",ProtocolBean.class);
        System.out.println("protocolBean:"+protocolBean.getPort());

        applicationContext.close();
    }
}
