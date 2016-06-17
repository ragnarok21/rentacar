package com.rentacar.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String model;
    @Column
    private String color;
    @Column
    private String brand;
    @Column
    private String licence;
    @Column
    private int year;
    @OneToOne
    @JoinColumn(name = "CARTYPE_ID")
    private CarType carType;

    public Car(String model, String color, String brand, String licence, int year,CarType carType) {
        this.model = model;
        this.color = color;
        this.brand = brand;
        this.licence = licence;
        this.year = year;
        this.carType = carType;
    }
}
