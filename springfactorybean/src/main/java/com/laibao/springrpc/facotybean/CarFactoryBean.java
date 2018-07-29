package com.laibao.springrpc.facotybean;
import com.laibao.springrpc.builder.CarBuilder;
import com.laibao.springrpc.domain.Car;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author laibao wang
 * @date 2018-07-30
 * @version 1.0
 */
public class CarFactoryBean implements FactoryBean<Car>,InitializingBean{

    private String brand;

    private String maker;

    private int year ;

    private CarBuilder carBuilder;

    public Car getObject() throws Exception {
        return carBuilder.createCar();
    }

    public Class<?> getObjectType() {
        return Car.class;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public String getMaker() {
        return maker;
    }

    public int getYear() {
        return year;
    }

    public void afterPropertiesSet() throws Exception {
        carBuilder = CarBuilder.car();
        if (StringUtils.isNotBlank(brand)) {
            carBuilder.setBrand(brand);
        }
        if (StringUtils.isNotBlank(maker)) {
            carBuilder.setMaker(maker);
        }
        if (year > 0 ) {
            carBuilder.setYear(year);
        }
    }
}
