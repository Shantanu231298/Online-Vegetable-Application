package com.cg.ova.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.ova.dao.IUserRepository;
import com.cg.ova.entity.Role;
import com.cg.ova.entity.User;
import com.cg.ova.exception.UserNotFoundException;
import com.cg.ova.model.UserModel;
import com.cg.ova.service.UserServiceImpl;




@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {
	@Mock
	private IUserRepository userDAO;

	@InjectMocks /*
					 * injecting package repository marked as @Mock into package service
					 * implementation
					 */
	private UserServiceImpl userImpl;
	
	//to view user
	@Test
	@DisplayName("UserServiceImpl::viewUser should view list of existing packages as UserModel List")
	void testViewUser() throws UserNotFoundException {
		User testdata = new User(1L, "12345", Role.Admin);
		UserModel expected = new UserModel(1L, "12345", "Admin");
		
		
		Mockito.when(userDAO.findById(1L)).thenReturn(Optional.of(testdata));
		UserModel actual = userImpl.viewUser(1L);
		assertEquals(expected, actual);
	}
	
	

	
	}
