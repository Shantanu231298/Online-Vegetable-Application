package com.cg.ova.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ova.exception.CustomerIdNotFoundException;
import com.cg.ova.model.CustomerModel;
import com.cg.ova.service.ICustomerService;

@RestController
@RequestMapping(path="/customer")
@CrossOrigin
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;
    
    //add customer
    //return : customer details
    //params : NIL
    @PostMapping("/cust")
    public ResponseEntity<String> addCustomer(
            @RequestBody @Valid CustomerModel customerModel, 
            BindingResult result) throws CustomerIdNotFoundException {
        
        if (result.hasErrors()) {
            throw new CustomerIdNotFoundException(GlobalExceptionHandler.messageFrom(result));
        }
        CustomerModel customerModel1 = customerService.addCustomer(customerModel);
        return new ResponseEntity<String>("Customer "+ customerModel1.getCustomerId() +" Created", HttpStatus.CREATED);
    }
    
    //update customer
    //return : customer
    // params : customer id
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerModel> updateCustomer(@RequestBody @Valid CustomerModel customerModel) throws CustomerIdNotFoundException {
        
        customerModel = customerService.updateCustomer(customerModel);
        
        return new ResponseEntity<>(customerModel, HttpStatus.OK);
    }
    
    //delete customer with id
    //return : void
    //params : customer id
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Boolean> RemoveCustomer(@PathVariable("customerId") Long customerId) throws CustomerIdNotFoundException {
        return ResponseEntity.ok(customerService.removeCustomer(customerId));
    }
    
    //get customer with id
    //return  : single customer
    //params : customer id
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerModel> viewCustomer(@PathVariable("customerId") Long customerId) throws CustomerIdNotFoundException {
    ResponseEntity<CustomerModel> response = null;
    CustomerModel customer = customerService.viewCustomer(customerId);
    if (customer == null) {
        response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
        customerService.viewCustomer(customerId);
        response = new ResponseEntity<>(customer, HttpStatus.OK);
    }
    return response;
    
    }
}