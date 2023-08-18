package com.cg.ova.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import com.cg.ova.dao.IVegetableDTORepository;
import com.cg.ova.entity.VegetableDTO;
import com.cg.ova.exception.VegetableIdNotFoundException;
import com.cg.ova.model.VegetableDTOModel;
import com.cg.ova.service.VegetableDTOServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
	public class VegetableDTOServiceImplTest {

		@Mock
		private IVegetableDTORepository vegetableDAO;

		@InjectMocks /*
						 * injecting package repository marked as @Mock into package service
						 * implementation
						 */
						 
		private VegetableDTOServiceImpl vegetableImpl;
		BigDecimal bd= new BigDecimal("100.00");
		BigInteger bi= new BigInteger("100");
		
		
        //to add vegetables
		@Test
		@DisplayName("VegetableServiceImpl::addVegetable should add list of existing packages as VegetableModel List")
		void testAddVegetable() throws VegetableIdNotFoundException {
			VegetableDTO testdata = new VegetableDTO(10L,"ORANGE","FRUIT",bi,20);
			
			VegetableDTOModel expected = new VegetableDTOModel(10L,"ORANGE","FRUIT",bi,20);

			//Mockito.when(vegetableDAO.existsById(10L)).thenReturn(true);
			Mockito.when(vegetableDAO.save(testdata)).thenReturn(testdata);
			
			VegetableDTOModel actual = vegetableImpl.addVegetable(expected);
			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("VegetableServiceImpl::updateVegetable should updated list of existing packages as VegetableDTOModel List")
		void testUpdateVegetable() throws VegetableIdNotFoundException {
			VegetableDTO testdata = new VegetableDTO(10L,"ORANGE","FRUIT",bi,20);
			VegetableDTOModel expected = new VegetableDTOModel(10L,"ORANGE","FRUIT",bi,20);

			Mockito.when(vegetableDAO.findById( testdata.getVegId())).thenReturn(Optional.of(testdata));
			Mockito.when(vegetableDAO.save(testdata)).thenReturn(testdata);
			
			VegetableDTOModel actual = vegetableImpl.updateVegetable(expected);
			assertEquals(expected, actual);

		}

		@Test
		@DisplayName("VegetableServiceImpl::removeVegetables should remove list of existing packages as VegetableDTOModel list")
		void testRemoveVegetable() throws VegetableIdNotFoundException {
			VegetableDTO testdata = new VegetableDTO(10L,"ORANGE","FRUIT",bi,20);
			VegetableDTOModel expected = new VegetableDTOModel(10L,"ORANGE","FRUIT",bi,20);


		    Mockito.when(vegetableDAO.findById(10L)).thenReturn(Optional.of(testdata));
			Mockito.doNothing().when(vegetableDAO).deleteById(10L);
			boolean result = vegetableImpl.removeVegetable(10L);
			assertTrue(result);
		}

	  

		@Test
		@DisplayName("VegetableServiceImpl::viewVegetable should return list of existing packages as VegetableDTOmodel ")
		void testViewVegetable() throws VegetableIdNotFoundException  {
			VegetableDTO testdata = new VegetableDTO(10L,"ORANGE","FRUIT",bi,20);
			VegetableDTOModel expected = new VegetableDTOModel(10L,"ORANGE","FRUIT",bi,20);

			//Mockito.when(vegetableDAO.existsById(10L)).thenReturn(true);
			Mockito.when(vegetableDAO.findById(10L)).thenReturn(Optional.of(testdata));
			
			VegetableDTOModel actual= vegetableImpl.viewVegetable(10L);
			assertEquals(expected, actual);

		}
		


		

}
