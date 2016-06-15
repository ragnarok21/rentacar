package com.rentacar.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOKING_ID")
    private int id;
    @Column(name = "fecha_inicio")
    private Date startDate;
    @Column(name = "fecha_termino")
    private Date endDate;
    @OneToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @Column(name = "total_pago")
    private int dueAmount;
    @OneToOne
    @JoinColumn(name = "PICKBRANCH_ID")
    private Branch pickBranch;
    @OneToOne
    @JoinColumn(name = "DROPBRANCH_ID")
    private Branch dropBranch;
    @OneToMany(fetch=FetchType.LAZY)
    @JoinTable(name="BEXTRA",
            joinColumns=@JoinColumn(name="booking_id", referencedColumnName="BOOKING_ID"),
            inverseJoinColumns=@JoinColumn(name="bextra_id", referencedColumnName="BOOKINGEXTRA_ID"))
    private Set<BookingExtra> bookingExtra = new HashSet<>();
    public Booking(Date startDate, Date endDate, Car car, Customer customer, int dueAmount, Branch pickBranch, Branch dropBranch) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.car = car;
        this.customer = customer;
        this.dueAmount = dueAmount;
        this.pickBranch = pickBranch;
        this.dropBranch = dropBranch;
    }

    /*FALTA CALCULAR EL MONTO*/
    public int getDueAmount() {
        if(!bookingExtra.isEmpty()){
            return  dueAmount;
        }else{
            return dueAmount;
        }
    }

    public void addBookingExtra(BookingExtra booking){
        if(!bookingExtra.contains(booking)){
            bookingExtra.add(booking);
        }
    }
}
