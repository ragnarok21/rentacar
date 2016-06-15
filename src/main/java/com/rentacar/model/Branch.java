package com.rentacar.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "ciudad")
    private String city;
    @Column(name = "sector")
    private String sector;

    public Branch(String city, String sector){
        this.city = city;
        this.sector = sector;
    }

}
