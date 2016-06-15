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
public class BookingExtra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOKINGEXTRA_ID")
    private int id;
    @OneToOne
    @JoinColumn(name = "EXTRA_ID")
    private Extra extra;

    public BookingExtra(Extra extra){
        this.extra = extra;
    }

}
