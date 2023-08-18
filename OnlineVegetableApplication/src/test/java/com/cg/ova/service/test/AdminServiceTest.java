package com.cg.ova.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.ova.dao.IAdminRepository;
import com.cg.ova.entity.Admin;
import com.cg.ova.exception.AdminIdNotFoundException;
import com.cg.ova.model.AdminModel;
import com.cg.ova.service.AdminServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AdminServiceTest {
	@Mock
	private IAdminRepository adminDAO;
 
	               /*
					 * injecting package repository marked as @Mock into package service
					 * implementation
	
					 */
	@InjectMocks
	private AdminServiceImpl adminImpl;
	
	//for adding new admin
	@Test
	@DisplayName("AdminServiceImpl::addAdmin should add list of existing packages as AdminModel List")
	void testAddAdmin() throws AdminIdNotFoundException {
		Admin testdata = new Admin(5L,"Pankhuri","9874567347");
		AdminModel expected = new AdminModel(5L,"Pankhuri","9874567347");

		Mockito.when(adminDAO.save(testdata)).thenReturn(testdata);
		
		AdminModel actual = adminImpl.addAdmin(expected);
		assertEquals(expected, actual);
	}
	

	//for updating admin details
	@Test
	@DisplayName("AdminServiceImpl::updateAdminDetails should update list of existing packages as AdminModel List")
	void testUpdateAdminDetails() throws AdminIdNotFoundException {
		Admin testdata = new Admin(5L,"Pankhuri","9874567347");
		AdminModel expected = new AdminModel(5L,"Riya","9874567347");
          testdata.setName("Riya");

			Mockito.when(adminDAO.findById(testdata.getAdminId())).thenReturn(Optional.of(testdata));
			Mockito.when(adminDAO.save(testdata)).thenReturn(testdata);

			AdminModel actual = adminImpl.updateAdminDetails(expected);
			assertEquals(expected, actual);
	}
	 
	
	//for removing admin
	@Test
	@DisplayName("AdminServiceImpl::removeAdmin should delete list of existing packages as AdminModel List")
	void testRemoveAdmin() throws AdminIdNotFoundException {
		Admin testdata = new Admin(5L,"Pankhuri","9874567347");
		AdminModel expected = new AdminModel( 5L,"Pankhuri","9874567347");
		
		Mockito.when(adminDAO.findById(5L)).thenReturn(Optional.of(testdata));
		Mockito.doNothing().when(adminDAO).deleteById(5L);
		boolean result = adminImpl.removeAdmin(5L);
		assertTrue(result);
	}
	
	//to view admin details
	@Test
	@DisplayName("AdminServiceImpl::ViewAdmin should return list of existing packages as AdminModel List")
	void testViewAdmin() throws AdminIdNotFoundException {
		Admin testdata = new Admin(5L,"Pankhuri","9874567347");
		AdminModel expected = new AdminModel(5L,"Pankhuri","9874567347");

		Mockito.when(adminDAO.findById(5L)).thenReturn(Optional.of(testdata));
		AdminModel actual = adminImpl.viewAdmin(5L);
		assertEquals(expected, actual);
	}

	
}
