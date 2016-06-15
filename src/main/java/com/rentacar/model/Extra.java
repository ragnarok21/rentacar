package com.rentacar.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Extra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private int dailyPrice;

    private Extra(String name, String description, int dailyPrice){
        this.name = name;
        this.description = description;
        this.dailyPrice = dailyPrice;
    }

}
