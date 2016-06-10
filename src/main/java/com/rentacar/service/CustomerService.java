package com.rentacar.service;

import com.rentacar.model.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer();
    List<Customer> getAllCustomer();
}
