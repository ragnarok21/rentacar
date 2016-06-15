package com.rentacar.model.builder;

import com.rentacar.model.Car;
import com.rentacar.model.CarType;

public class CarBuilder {
    private Car car;
    private String model;
    private String color;
    private String brand;
    private String licence;
    private int year;
    private CarType carType;

    public CarBuilder setModel(String model){
        this.model = model;
        return this;
    }
    public CarBuilder setColor(String color){
        this.color = color;
        return this;
    }
    public CarBuilder setBrand(String brand){
        this.brand = brand;
        return this;
    }
    public CarBuilder setLicence(String licence){
        this.licence = licence;
        return this;
    }
    public CarBuilder setYear(int year){
        this.year = year;
        return this;
    }
    public CarBuilder setCarType(CarType carType){
        this.carType = carType;
        return this;
    }
    public Car buildCar(){
        car = new Car(model,color,brand,licence,year,carType);
        return car;
    }
}
