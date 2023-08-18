package com.cg.ova.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.ova.dao.IFeedbackRepository;
import com.cg.ova.entity.Customer;
import com.cg.ova.entity.Feedback;
import com.cg.ova.entity.VegetableDTO;
import com.cg.ova.exception.FeedbackIdNotFoundException;
import com.cg.ova.model.AddressModel;
import com.cg.ova.model.CustomerModel;
import com.cg.ova.model.FeedbackModel;
import com.cg.ova.model.VegetableDTOModel;
import com.cg.ova.service.FeedbackServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FeedbackServiceImplTest {

	@Mock
	private IFeedbackRepository feedbackDAO;

	@InjectMocks /*
					 * injecting package repository marked as @Mock into package service
					 * implementation
					 */
private FeedbackServiceImpl feedbackImpl;
	
	BigInteger bi= new BigInteger("100");
	BigDecimal bd= new BigDecimal("100.00");
	
    Customer customer1=new Customer(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",new AddressModel("B-120","Abc","sector21","Noida","UP","20316"));
    CustomerModel customer2=new CustomerModel(12L,"Rahul", "8447630809", "Rahul@gmail.com","abc13",new AddressModel("B-120","Abc","sector21","Noida","UP","20316"));

    VegetableDTO veg1=new VegetableDTO(10L,"ORANGE","FRUIT",bi,20);
    VegetableDTOModel veg2=new VegetableDTOModel(10L,"ORANGE","FRUIT",bi,20);	



    //to add new feedback
    @Test
	@DisplayName("FeedbackServiceImpl::addFeedback  should add list of existing packages as FeedbackModel List")
	void testAddFeedback() throws FeedbackIdNotFoundException{
		Feedback testdata = new Feedback(1L,customer1,veg1,8L,"GOOD");
		FeedbackModel expected = new FeedbackModel(1L,customer2,veg2,8L,"GOOD");


		Mockito.when(feedbackDAO.save(testdata)).thenReturn(testdata);
		FeedbackModel actual = feedbackImpl.addFeedback(expected);
		assertEquals(expected, actual);
	}
    
    //to view feedback
    @Test
	@DisplayName("FeedbackServiceImpl::viewFeedbaack should return list of existing packages as FeedbackModel List")
    void  testViewFeedback() throws FeedbackIdNotFoundException{
		
		Feedback testdata = new Feedback(1L,customer1,veg1,8L,"GOOD");
		FeedbackModel expected = new FeedbackModel(1L,customer2,veg2,8L,"GOOD");
	
		
				Mockito.when(feedbackDAO.findById(1L)).thenReturn(Optional.of(testdata));
		FeedbackModel actual = feedbackImpl.viewFeedback(1L);
		assertEquals(expected, actual);
		
		
		
	}
  
	
}