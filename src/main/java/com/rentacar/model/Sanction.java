package com.rentacar.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Sanction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String description;
    @Column
    private Date startDate;
    @Column
    private int days;
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public Sanction(String description, Date startDate, int days, Customer customer){
        this.description = description;
        this.startDate = startDate;
        this.days = days;
        this.customer = customer;
    }
}
