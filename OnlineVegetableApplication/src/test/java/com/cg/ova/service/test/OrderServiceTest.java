package com.cg.ova.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
import com.cg.ova.dao.IOrderRepository;
import com.cg.ova.entity.Customer;
import com.cg.ova.entity.Order;
import com.cg.ova.entity.OrderStatus;
import com.cg.ova.exception.OrderIdNotFoundException;
import com.cg.ova.model.AddressModel;
import com.cg.ova.model.CustomerModel;
import com.cg.ova.model.OrderModel;
import com.cg.ova.service.OrderServiceImpl;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class OrderServiceTest {

	@Mock
	private IOrderRepository orderDAO;

	@InjectMocks /*
					 * injecting package repository marked as @Mock into package service
					 * implementation
					 * */
					 
	private OrderServiceImpl orderImpl;

	BigDecimal bd= new BigDecimal("100.00");
	

	
	Customer customer1=new Customer(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",new AddressModel("B-120","Abc","sector21","Noida","UP","20316"));
	CustomerModel customer2=new CustomerModel(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",new AddressModel("B-120","Abc","sector21","Noida","UP","20316"));


	//to add order
	@Test
	@DisplayName("OrderServiceImpl::addOrder should add order details in existing packages as OrderModel List")
	void testAddOrder() throws OrderIdNotFoundException {
		Order testdata = new Order(1L,customer1,bd,LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),OrderStatus.Delivered);
		OrderModel expected = new OrderModel(1L,customer2,bd,LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),OrderStatus.Delivered);

		 Mockito.when(orderDAO.existsById(1L)).thenReturn(true);
		Mockito.when(orderDAO.save(testdata)).thenReturn(testdata);
		
		OrderModel actual = orderImpl.addOrder(expected);
		assertEquals(expected, actual);
	}

	//to update order
	@Test
	@DisplayName("OrderServiceImpl::updatOrder should update list of existing packages as OrderModel List")
	void testUpdateOrder() throws OrderIdNotFoundException {
		Order testdata = new Order(1L,customer1,bd,LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),OrderStatus.Delivered);
		OrderModel expected = new OrderModel(1L,customer2,bd,LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),OrderStatus.Delivered);

		
		Mockito.when(orderDAO.findById(testdata.getOrderNo())).thenReturn(Optional.of(testdata));
		Mockito.when(orderDAO.save(testdata)).thenReturn(testdata);
		
		OrderModel actual = orderImpl.updateOrder(expected);
		assertEquals(expected, actual);

	}

	//to cancel order
	@Test
	@DisplayName("PackageServiceImpl::removeOrder should delete list of existing packages as OrderModel List")
	void testRemoveOrder() throws OrderIdNotFoundException {
		Order testdata = new Order(1L,customer1,bd,LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),OrderStatus.Delivered);
		OrderModel expected = new OrderModel(1L,customer2,bd,LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),OrderStatus.Delivered);

		  Mockito.when(orderDAO.findById(1L)).thenReturn(Optional.of(testdata));
			Mockito.doNothing().when(orderDAO).deleteById(1L);
			boolean result = orderImpl.cancelOrder(1L);
			assertTrue(result);
	}
	

   


	@Test
	@DisplayName("OrderServiceImpl::vieworder should return list of existing packages as Ordermodel List")
	void testViewOrder() throws OrderIdNotFoundException  {
		Order testdata = new Order(1L,customer1,bd,LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),OrderStatus.Delivered);
		OrderModel expected = new OrderModel(1L,customer2,bd,LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),OrderStatus.Delivered);

		Mockito.when(orderDAO.existsById(1L)).thenReturn(true);
		Mockito.when(orderDAO.findById(1L)).thenReturn(Optional.of(testdata));
		
		OrderModel actual= orderImpl.viewOrderList(1L);
		assertEquals(expected, actual);

	}
	@Test
	@DisplayName("CartServiceImpl : viewAllCarts for viewing all the carts")
	public void testViewAllOrder() throws OrderIdNotFoundException{
		
		List<Order> testData= Arrays.asList(new Order[] {
				
				new Order(1L,customer1,bd,LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),OrderStatus.Delivered),
				new Order(2L,customer1,bd,LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),OrderStatus.Delivered)
				});
		
		Mockito.when(orderDAO.findAll()).thenReturn(testData);

		List<OrderModel> expected= Arrays.asList(new OrderModel[] {
				new OrderModel(1L,customer2,bd,LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),OrderStatus.Delivered),
				new OrderModel(2L,customer2,bd,LocalDateTime.of(LocalDate.of(2021, 04, 23), LocalTime.of(16,45)),OrderStatus.Delivered)
		});
		
		List<OrderModel> actual = orderImpl.viewAllOrder();
		assertEquals(expected, actual);
	
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
