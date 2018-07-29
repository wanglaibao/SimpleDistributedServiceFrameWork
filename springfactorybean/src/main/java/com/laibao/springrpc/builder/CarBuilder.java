package com.laibao.springrpc.builder;

import com.laibao.springrpc.domain.Car;

/**
 * @author laibao wang
 * @date 2018-07-30
 * @version 1.0
 */
public class CarBuilder {
    private String brand;
    private  String maker;
    private  int year ;

    private CarBuilder() {

    }

    public static CarBuilder car() {
        CarBuilder carBuilder = new CarBuilder();
        return carBuilder;
    }

    public CarBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarBuilder setMaker(String maker) {
        this.maker = maker;
        return this;
    }

    public CarBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public Car createCar() {
        return new Car(brand,maker,year);
    }
}
