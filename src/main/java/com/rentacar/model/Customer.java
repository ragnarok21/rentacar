package com.rentacar.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
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
    @Column(unique = true)
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_CATEGORY_ID")
    private CustomerCategory category;

    public Customer(String name, String rut, int cellphone, String email, CustomerCategory category){
        this.name = name;
        this.rut = rut;
        this.cellphone = cellphone;
        this.email = email;
        this.category = category;
    }
}
