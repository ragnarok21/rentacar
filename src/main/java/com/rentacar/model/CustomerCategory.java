package com.rentacar.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Categoria")
public class CustomerCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;

    public CustomerCategory(String name) {
        this.name = name;
    }
}
