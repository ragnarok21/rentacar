package com.rentacar.impl;

import com.rentacar.exception.CreateErrorException;
import com.rentacar.exception.EmptyListException;
import com.rentacar.model.*;
import com.rentacar.model.builder.CarBuilder;
import com.rentacar.model.builder.CarTypeBuilder;
import com.rentacar.model.builder.CustomerBuilder;
import com.rentacar.service.CustomerService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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
    public void createCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        if(exist(customer.getId())){
            session.save(customer);
            tx.commit();
        }else{
           throw new CreateErrorException("Error al crear un cliente");
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Customer> list = session.createCriteria(Customer.class).list();
        if(!list.isEmpty()){
            return list;
        }else{
            throw new EmptyListException("La lista esta vacía");
        }
    }

    @Override
    public boolean exist(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(Customer.class).add(Restrictions.eq("id",id));
        Customer customer = (Customer) c.uniqueResult();
        return customer == null;
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
