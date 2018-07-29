package com.laibao.springrpc.configuration;

import com.laibao.springrpc.domain.Car;
import com.laibao.springrpc.facotybean.CarFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author laibao wang
 * @date 2018-07-30
 * @version 1.0
 */
@Configuration
public class FactoryBeanConfig {

    @Bean(name = "carFactoryBean")
    public CarFactoryBean carFactoryBean() {
        CarFactoryBean carFactoryBean = new CarFactoryBean();
        carFactoryBean.setBrand("宝马");
        carFactoryBean.setMaker("德国");
        carFactoryBean.setYear(1990);
        return carFactoryBean;
    }

    @Bean
    public Car car() throws Exception {
        return carFactoryBean().getObject();
    }


}
