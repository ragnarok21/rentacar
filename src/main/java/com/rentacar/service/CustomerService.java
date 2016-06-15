package com.rentacar.service;

import com.rentacar.model.Customer;

import java.util.List;

public interface CustomerService {
    void createCustomer(Customer customer);
    List<Customer> getAllCustomer();
    boolean exist(String email);
}
