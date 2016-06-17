package com.rentacar.controller;

import com.rentacar.exception.CreateErrorException;
import com.rentacar.exception.DeleteErrorException;
import com.rentacar.exception.EmptyListException;
import com.rentacar.model.Customer;
import com.rentacar.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private static Logger log = Logger.getLogger(CustomerController.class);

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> addCustomer(){
        log.info("Añadiendo un cliente");
        Customer c = new Customer();
        c.setEmail("rduran@nisum.com");
        try {
            customerService.createCustomer(c);
            return new ResponseEntity<>(OK);

        }catch(CreateErrorException e){
            return new ResponseEntity<>(e.getMsg(),NOT_ACCEPTABLE);
        }

    }
    @RequestMapping(value = "/getall" , method = RequestMethod.GET)
    public ResponseEntity getAllCustomer(){
        try {
            return new ResponseEntity<>(customerService.getAllCustomer(),OK);
        }catch (EmptyListException e){
            return new ResponseEntity<>(e.getMsg(),NOT_ACCEPTABLE);
        }

    }

    @RequestMapping(value = "/delete" , method = RequestMethod.DELETE)
    public ResponseEntity deleteCustomer(){
        String email = "rduran@nisum.com";
        try {
            customerService.deleteCustomer(email);
            return new ResponseEntity<>(OK);
        }catch (DeleteErrorException e){
            return new ResponseEntity<>(e.getMsg(),NOT_FOUND);
        }

    }
}
