package com.cg.ova.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.ova.dao.IBillingDetailsRepository;
import com.cg.ova.entity.BillingDetails;
import com.cg.ova.entity.Customer;
import com.cg.ova.entity.Order;
import com.cg.ova.entity.OrderStatus;
import com.cg.ova.exception.BillIdNotFoundException;
import com.cg.ova.model.AddressModel;
import com.cg.ova.model.BillingDetailsModel;
import com.cg.ova.model.CustomerModel;
import com.cg.ova.model.OrderModel;
import com.cg.ova.service.BillingDetailsImpl;


@ExtendWith(MockitoExtension.class)
public class BillingDetailsServiceTest {
	@Mock
	private IBillingDetailsRepository billDAO;

	                /*
					 * injecting package repository marked as @Mock into package service
					 * implementation
					 */
	@InjectMocks
	private BillingDetailsImpl billImpl;
	
	BigDecimal bd= new BigDecimal("100.00");
	
	Customer customer1=new Customer(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",new AddressModel("B-120","Abc","sector21","Noida","UP","20316"));
	CustomerModel customer2=new CustomerModel(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",new AddressModel("B-120","Abc","sector21","Noida","UP","20316"));
	
	Order order1=new Order(1L,customer1,bd,LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),OrderStatus.Delivered);
	OrderModel order2=new OrderModel(1L,customer2,bd,LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),OrderStatus.Delivered);
	
	//for add new bill
	@Test
	@DisplayName("BillingDetailsServiceImpl::addBill should add list of existing packages as BillingModel List")
	void testAddBill() throws BillIdNotFoundException {
		BillingDetails testdata = new BillingDetails(10L,"online", LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),"SUCCESS",order1);
		BillingDetailsModel expected = new BillingDetailsModel(10L,"online", LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),"SUCCESS",order2);

		
		Mockito.when(billDAO.save(testdata)).thenReturn(testdata);
		
		
		BillingDetailsModel actual = billImpl.addBill(expected);
		assertEquals(expected, actual);
	}

	
    //to update bill
	@Test
	@DisplayName("BillingDetailsServiceImpl::updateBill should add list of existing packages as BillingModel List")
	void testUpdateBill() throws BillIdNotFoundException {
		BillingDetails testdata = new BillingDetails(10L,"online", LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),"SUCCESS",order1);
		BillingDetailsModel expected = new BillingDetailsModel(11L,"online", LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),"SUCCESS",order2);


		testdata.setBillingId(11L);

		Mockito.when(billDAO.findById(testdata.getBillingId())).thenReturn(Optional.of(testdata));
		Mockito.when(billDAO.save(testdata)).thenReturn(testdata);

		BillingDetailsModel actual = billImpl.updateBill(expected);
		assertEquals(expected, actual);
	}
	
	//to view bill by billl id
	@Test
	@DisplayName("BillingDetailsServiceImpl::viewBill should add list of existing packages as BillingModel List")
	void testViewBill() throws BillIdNotFoundException {
		BillingDetails testdata = new BillingDetails(10L,"online", LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),"SUCCESS",order1);
		BillingDetailsModel expected = new BillingDetailsModel(10L,"online", LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),"SUCCESS",order2);

		Mockito.when(billDAO.findById(10L)).thenReturn(Optional.of(testdata));
		BillingDetailsModel actual = billImpl.viewBill(10L);
		assertEquals(expected, actual);
	}
	
	
	
	
}