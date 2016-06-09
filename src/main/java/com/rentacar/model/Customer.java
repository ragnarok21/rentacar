package com.rentacar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Cliente")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String rut;
    @Column
    private int cellphone;
    @Column
    private String email;
    @OneToOne
    private CustomerCategory category;
}
