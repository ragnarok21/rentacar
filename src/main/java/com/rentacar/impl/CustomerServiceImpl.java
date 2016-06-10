package com.rentacar.impl;

import com.rentacar.model.*;
import com.rentacar.model.builder.CarBuilder;
import com.rentacar.model.builder.CarTypeBuilder;
import com.rentacar.model.builder.CustomerBuilder;
import com.rentacar.service.CustomerService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomer() {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Customer customer = new CustomerBuilder().withName("jose").withRut("11233").withCellphone(11232).withEmail("asd@asd.com").withCustomerCategory(new CustomerCategory("sdsdsds")).build();
        session.save(customer);
        session.getTransaction().commit();
        System.out.print("Successfull");
    }

    @Override
    public List<Customer> getAllCustomer() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session.createCriteria(Customer.class).list();
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
