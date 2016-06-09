package com.rentacar.impl;

import com.rentacar.model.Customer;
import com.rentacar.service.CustomerService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomer() {

        Session session = sessionFactory.getCurrentSession();
        System.out.println(session.isOpen());
        session.beginTransaction();
        Customer customer = new Customer();
        customer.setName("asdsad");
        customer.setEmail("asdasd");
        session.save(customer);
        session.getTransaction().commit();
        System.out.print("Successfull");
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
