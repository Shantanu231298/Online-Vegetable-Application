package com.cg.ova.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ova.dao.ICustomerRepository;
import com.cg.ova.entity.Customer;
import com.cg.ova.model.CustomerModel;

@Service
public class EMParserCustomer {
	@Autowired
	private ICustomerRepository customerDAO;
	public EMParserCustomer() {
		//no impl
	}
	
	//convert customer entity to customer model
 public Customer parse(CustomerModel source) {
		return source==null?null:
			new Customer (source.getCustomerId(), 
					source.getName(),
					source.getMobileNumber(),
					source.getEmailId(),
					source.getPassword(),
			        source.getAddress());
	}
	
 //convert customer model to customer entity
 public CustomerModel  parse(Customer source) {
		return source==null?null:
			new CustomerModel(source.getCustomerId(),
					source.getName(),
					source.getMobileNumber(),
					source.getEmailId(),
					source.getPassword(),
					source.getAddress());
					}

}
