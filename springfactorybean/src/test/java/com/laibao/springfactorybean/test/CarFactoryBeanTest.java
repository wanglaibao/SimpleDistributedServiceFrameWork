package com.laibao.springfactorybean.test;

import com.alibaba.fastjson.JSON;
import com.laibao.springrpc.domain.Car;
import com.laibao.springrpc.facotybean.CarFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * @author laibao wang
 * @date 2018-07-30
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/factorybean.xml"})
public class CarFactoryBeanTest {

    @Autowired
    private Car car;

    @Resource(name = "&carFactoryBean")
    private CarFactoryBean carFactoryBean;

    @Test
    public void testCarInstanceCreatedByFactoryBean() {
        System.out.println(JSON.toJSONString(car));
    }

    @Test
    public void testFactoryBeanSelf() {
        String brand = carFactoryBean.getBrand();
        String maker = carFactoryBean.getMaker();
        int year = carFactoryBean.getYear();
        System.out.println("brand : "+brand + " maker : "+maker +" year : "+year);
        System.out.println();
        System.out.println(JSON.toJSONString(carFactoryBean));
    }
}
