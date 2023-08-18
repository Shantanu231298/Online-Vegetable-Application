package com.cg.ova.service;

import java.util.List;

import com.cg.ova.exception.CustomerIdNotFoundException;
import com.cg.ova.model.CustomerModel;

public interface ICustomerService {
	/* definition of addCustomer method for adding new customer */
	public CustomerModel addCustomer(CustomerModel customerModel) throws CustomerIdNotFoundException;
	
	/* definition of updateCustomer method for updating customer */
	public CustomerModel updateCustomer(CustomerModel customerModel)throws CustomerIdNotFoundException;
	
	/* definition of removeCustomer method for removing customer */
    public boolean  removeCustomer(Long customerId) throws CustomerIdNotFoundException;
    
    /* definition of viewCustomer method for viewing particular customer */
	public CustomerModel viewCustomer(Long customerId) throws CustomerIdNotFoundException;
	
	/* definition of viewAllCustomer method for viewing all customer */
	public List<CustomerModel> viewAllCustomer() throws CustomerIdNotFoundException;


}
