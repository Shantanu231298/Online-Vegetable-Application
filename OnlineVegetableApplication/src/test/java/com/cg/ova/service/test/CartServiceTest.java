package com.cg.ova.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.ova.dao.ICartDTORepository;
import com.cg.ova.entity.CartDTO;
import com.cg.ova.entity.Customer;
import com.cg.ova.exception.CartIdNotFoundException;
import com.cg.ova.model.AddressModel;
import com.cg.ova.model.CartDTOModel;
import com.cg.ova.model.CustomerModel;
import com.cg.ova.model.VegetableDTOModel;
import com.cg.ova.service.CartDTOServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
	public class CartServiceTest {
		@Mock
		private ICartDTORepository cartDAO;
	 
		               /*
						 * injecting package repository marked as @Mock into package service
						 * implementation
		                  */
		@InjectMocks
		private CartDTOServiceImpl cartImpl;
		BigInteger bi= new BigInteger("100");
		
		Customer customer1=new Customer(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",new AddressModel("B-120","Abc","sector21","Noida","UP","20316"));
		CustomerModel customer2=new CustomerModel(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",new AddressModel("B-120","Abc","sector21","Noida","UP","20316"));

		VegetableDTOModel veg=new VegetableDTOModel();
	
		//to add item to cart
		@Test
		@DisplayName("OrderServiceImpl::addToCart should add cart details in existing packages as CartModel List")
		void testAddToCart() throws CartIdNotFoundException {
			
			CartDTO testdata = new CartDTO(1L,customer1);
			CartDTOModel expected = new CartDTOModel(1L,customer2);
			
			
			//cartDAO.existsById(veg.getVegId()))
           // Mockito.when(cartDAO.existsById(veg.getVegId())).thenReturn(true);
			Mockito.when(cartDAO.save(testdata)).thenReturn(testdata);
			
			CartDTOModel actual = cartImpl.addToCart(expected, veg);
			assertEquals(expected, actual);
		}

	
		
	

}
