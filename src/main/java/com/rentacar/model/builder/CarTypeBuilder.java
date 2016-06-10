package com.rentacar.model.builder;

import com.rentacar.model.CarType;
import com.rentacar.model.FuelType;
import com.rentacar.model.Transmition;

public class CarTypeBuilder {
    private CarType carType;
    private String name;
    private Transmition transmitionType;
    private FuelType fuelType;
    private int bags;
    private int passengers;
    private int dailyPrice;

    public CarTypeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CarTypeBuilder setTransmitionType(Transmition transmitionType) {
        this.transmitionType = transmitionType;
        return this;
    }

    public CarTypeBuilder setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public CarTypeBuilder setBags(int bags) {
        this.bags = bags;
        return this;
    }

    public CarTypeBuilder setPassengers(int passengers) {
        this.passengers = passengers;
        return this;
    }

    public CarTypeBuilder setDailyPrice(int dailyPrice) {
        this.dailyPrice = dailyPrice;
        return this;
    }

    public CarType buildCarType(){
        carType = new CarType(name,transmitionType,fuelType,bags,passengers,dailyPrice);
        return carType;
    }
}
