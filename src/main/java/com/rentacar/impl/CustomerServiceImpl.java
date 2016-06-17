package com.rentacar.impl;

import com.rentacar.exception.*;
import com.rentacar.model.*;
import com.rentacar.service.CustomerService;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if(!customerExist){
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
    public void deleteCustomer(String email) {
        Customer customer = this.getCustomer(email);
        if(customer!=null){
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.delete(customer);
        }else{
            throw new DeleteErrorException("No es posible eliminar");
        }
    }

    @Override
    public Customer getCustomer(String email) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(Customer.class).add(Restrictions.eq("email",email));
        Customer customer = (Customer) c.uniqueResult();
        if(customer!=null){
            return customer;
        }else{
          throw new GetErrorException("Cliente no existe");
        }
    }


    @Override
    public boolean exist(String email) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(Customer.class).add(Restrictions.eq("email",email));
        Customer customer = (Customer) c.uniqueResult();
        return customer != null;
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
