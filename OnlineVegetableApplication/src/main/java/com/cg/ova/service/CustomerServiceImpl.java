package com.cg.ova.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ova.dao.ICustomerRepository;
import com.cg.ova.entity.Customer;
import com.cg.ova.exception.CustomerIdNotFoundException;
import com.cg.ova.model.CustomerModel;
import com.cg.ova.util.EMParserCustomer;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerRepository customerDAO;
	
	@Autowired
	private EMParserCustomer parser;
	
	public CustomerServiceImpl() {
		this.parser = new EMParserCustomer();
	}
	
   public CustomerServiceImpl(ICustomerRepository customerDAO) {
		super();
		this.customerDAO = customerDAO;
		this.parser = new EMParserCustomer();
	}
   
   /* Implementation of addCustomer  to add all the customer */
	@Transactional
	@Override
	public CustomerModel addCustomer(CustomerModel customerModel) throws CustomerIdNotFoundException {
		if (customerModel != null) {
			if (customerDAO.existsById(customerModel.getCustomerId())) {
				throw new CustomerIdNotFoundException("Customer with this id already exists");
			}

			customerModel = parser.parse(customerDAO.save(parser.parse(customerModel)));
		}

		return customerModel;
	}
	
	/* Implementation of updateCustomer  to update all the customers */
    @Transactional
	@Override
	public CustomerModel updateCustomer(CustomerModel customerModel) throws CustomerIdNotFoundException {
    	Customer oldCustomer = customerDAO.findById(customerModel.getCustomerId()).orElse(null);
		if (oldCustomer == null) {
			throw new CustomerIdNotFoundException("no customer with id #" + customerModel.getCustomerId() + " present");
		} else {
			customerModel = parser.parse(customerDAO.save(parser.parse(customerModel)));
		}
		return customerModel;
	}
    
    /* Implementation of removeCustomer  to remove all the customer by id */
    @Transactional
	@Override
	public boolean removeCustomer(Long customerId) throws CustomerIdNotFoundException {
    	Customer oldCustomer = customerDAO.findById(customerId).orElse(null);
		boolean isDeleted=false;
		if (oldCustomer == null) {
			throw new CustomerIdNotFoundException("no loan with id #" + customerId + " present");
		} else {
			customerDAO.deleteById(customerId);
			isDeleted=true;
		}
		return isDeleted;
		
		
	}
  
    /* Implementation of viewCustomer  to view all the customer by id */
	@Override
	public CustomerModel viewCustomer(Long customerId) throws CustomerIdNotFoundException {
    	Customer oldCustomer = customerDAO.findById(customerId).orElse(null);
    	System.out.println(oldCustomer);
		if (oldCustomer == null) {
			throw new CustomerIdNotFoundException("no customer with id #" + customerId + " present");
		}
		return parser.parse(customerDAO.findById(customerId).orElse(null));
	}
	
	
	/* Implementation of viewAllCustomer  to view all the customers*/
	@Override
	public List<CustomerModel> viewAllCustomer() throws CustomerIdNotFoundException {

		return customerDAO.findAll().stream().map(parser::parse).collect(Collectors.toList());

	}
	
	
}
	

	


