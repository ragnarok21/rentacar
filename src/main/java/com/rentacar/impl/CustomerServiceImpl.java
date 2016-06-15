package com.rentacar.impl;

import com.rentacar.exception.CreateErrorException;
import com.rentacar.exception.EmptyListException;
import com.rentacar.exception.UpdateErrorException;
import com.rentacar.model.*;
import com.rentacar.model.builder.CarBuilder;
import com.rentacar.model.builder.CarTypeBuilder;
import com.rentacar.model.builder.CustomerBuilder;
import com.rentacar.service.CustomerService;
import org.hibernate.*;
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
        boolean customerExist = exist(customer.getEmail());
        if(customerExist){
            session.save(customer);
            tx.commit();
        }else{
           throw new CreateErrorException("El cliente ya existe");
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
    public void updateCustomer(Customer customer) {

    }

    @Override
    public boolean exist(String email) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(Customer.class).add(Restrictions.eq("email",email));
        Customer customer = (Customer) c.uniqueResult();
        return customer == null;
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
