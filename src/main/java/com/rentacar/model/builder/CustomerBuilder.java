package com.rentacar.model.builder;

import com.rentacar.model.Customer;
import com.rentacar.model.CustomerCategory;

public class CustomerBuilder {
    private Customer customer;
    private String name;
    private String rut;
    private int cellphone;
    private String email;
    private CustomerCategory customerCategory;

    public CustomerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder withRut(String rut) {
        this.rut = rut;
        return this;
    }

    public CustomerBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerBuilder withCustomerCategory(CustomerCategory customerCategory) {
        this.customerCategory = customerCategory;
        return this;
    }

    public CustomerBuilder withCellphone(int cellphone) {
        this.cellphone = cellphone;
        return this;
    }
    public Customer build(){
        customer = new Customer(name,rut,cellphone,email,customerCategory);
        return customer;
    }
}
