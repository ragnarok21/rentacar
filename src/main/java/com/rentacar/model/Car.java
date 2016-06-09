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
    @NonNull
    private String color;
    @Column
    private String brand;
    @Column
    private String licence;
    @Column
    private int year;

    public Car(String model, String color, String brand, String licence, int year) {
        this.model = model;
        this.color = color;
        this.brand = brand;
        this.licence = licence;
        this.year = year;
    }
}
