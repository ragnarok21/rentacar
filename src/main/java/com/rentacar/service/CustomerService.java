package com.rentacar.service;

import com.rentacar.model.Customer;

import java.util.List;

public interface CustomerService {
    void createCustomer(Customer customer);
    List<Customer> getAllCustomer();
    void updateCustomer(Customer customer);
    void deleteCustomer(String email);
    Customer getCustomer(String email);
    boolean exist(String email);
}
