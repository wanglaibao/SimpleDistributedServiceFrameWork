package com.laibao.springrpc.domain;

/**
 * @author laibao wang
 * @date 2018-07-30
 * @version 1.0
 */
public class Car {
    private final String brand;
    private final String maker;
    private final int year ;

    public Car(String brand,String maker,int year) {
        this.brand = brand;
        this.maker = maker;
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
}
