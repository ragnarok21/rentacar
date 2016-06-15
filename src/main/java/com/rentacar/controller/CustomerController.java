package com.rentacar.controller;

import com.rentacar.exception.CreateErrorException;
import com.rentacar.exception.EmptyListException;
import com.rentacar.model.Customer;
import com.rentacar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> addCustomer(){
        Customer c = new Customer();
        c.setEmail("rduran@nisum.com");
        try {
            customerService.createCustomer(c);
            return new ResponseEntity<String>(OK);

        }catch(CreateErrorException e){
            return new ResponseEntity<String>(e.getMsg(),NOT_ACCEPTABLE);
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
}
