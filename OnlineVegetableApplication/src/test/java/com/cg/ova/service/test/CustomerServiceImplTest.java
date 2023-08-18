package com.cg.ova.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ova.dao.ICustomerRepository;
import com.cg.ova.entity.Customer;
import com.cg.ova.exception.CustomerIdNotFoundException;
import com.cg.ova.model.AddressModel;
import com.cg.ova.model.CustomerModel;
import com.cg.ova.service.CustomerServiceImpl;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CustomerServiceImplTest {
 
    //mocking the Repository
	@Mock
	private ICustomerRepository customerDAO;
	
	      /*
		   * injecting package repository marked as @Mock into package service
		   * implementation
		   */
	@InjectMocks
	private CustomerServiceImpl customerImpl;

	
	AddressModel address = new AddressModel("B-120","Abc","sector21","Noida","UP","20316");

	
	//to add customer
	@Test
	@DisplayName("CustomerServiceImpl::addCustomer should ADD list of existing packages as CustomerModel List")
	void testAddCustomer() throws CustomerIdNotFoundException {
		Customer testdata = new Customer(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",new AddressModel("B-120","Abc","sector21","Noida","UP","20316"));
		CustomerModel expected = new CustomerModel(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",new AddressModel("B-120","Abc","sector21","Noida","UP","20316"));

		Mockito.when(customerDAO.save(testdata)).thenReturn(testdata);
		
		CustomerModel actual = customerImpl.addCustomer(expected);
		assertEquals(expected, actual);
	}

	//to update customer
	@Test
	@DisplayName("CustomerServiceImpl::UPDATE should update list of existing packages as CustomerModel List")
	void testUpdateCustomer() throws CustomerIdNotFoundException {
		Customer testdata = new Customer(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",address);
		CustomerModel expected = new CustomerModel(12L,"Shubham", "8447630809", "Rahul@gmail.com","abc13",address);


		testdata.setName("Shubham");

		Mockito.when(customerDAO.findById(testdata.getCustomerId())).thenReturn(Optional.of(testdata));
		Mockito.when(customerDAO.save(testdata)).thenReturn(testdata);

		CustomerModel actual = customerImpl.updateCustomer(expected);
		assertEquals(expected, actual);
	}
  //to remove customer
	@Test
	@DisplayName("CustomerServiceImpl::removeCustomer should remove list of existing packages as CustomerModel list")
	void testRemoveCustomer() throws CustomerIdNotFoundException {
		Customer testdata = new Customer(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",address);
	    CustomerModel expected = new CustomerModel(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",address);

	    Mockito.when(customerDAO.findById(12L)).thenReturn(Optional.of(testdata));
		Mockito.doNothing().when(customerDAO).deleteById(12L);
		boolean result = customerImpl.removeCustomer(12L);
		assertTrue(result);
        }
	
	
    // to view customer by customer id
	@Test
	@DisplayName("CustomerServiceImpl::viewCustomer should return list of existing packages as customermodel list")
	void testViewCustomer() throws CustomerIdNotFoundException  {
		Customer testdata = new Customer(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",address);
		CustomerModel expected = new CustomerModel(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",address);
		
		Mockito.when(customerDAO.findById(12L)).thenReturn(Optional.of(testdata));
		CustomerModel actual = customerImpl.viewCustomer(12L);
		assertEquals(expected, actual);
		
	}
	
	//to view all customers
	@Test
	@DisplayName("CartServiceImpl :viewAllCustomer for viewing all the customer")
	public void testViewAllCustomers() throws CustomerIdNotFoundException{
		
		List<Customer> testData= Arrays.asList(new Customer[] {
				
				new Customer(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",address),
				new Customer(13L,"Raj", "8447630807", "Raj@gmail.com","abc113",address)
				});
		
		Mockito.when(customerDAO.findAll()).thenReturn(testData);

		List<CustomerModel> expected= Arrays.asList(new CustomerModel[] {
				new CustomerModel(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",address),
				new CustomerModel(13L,"Raj", "8447630807", "Raj@gmail.com","abc113",address)
		});
		
		List<CustomerModel> actual = customerImpl.viewAllCustomer();
		assertEquals(expected, actual);
	
	}
}
	

	
	



