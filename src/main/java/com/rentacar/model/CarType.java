package com.rentacar.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class CarType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String transmitionType;
    @Column
    private String fuelType;
    @Column
    private int bags;
    @Column
    private int passengers;
    @Column
    private int dailyPrice;

    public CarType(String name, String transmitionType, String fuelType, int bags, int passengers, int dailyPrice) {
        this.name = name;
        this.transmitionType = transmitionType;
        this.fuelType = fuelType;
        this.bags = bags;
        this.passengers = passengers;
        this.dailyPrice = dailyPrice;
    }
}
