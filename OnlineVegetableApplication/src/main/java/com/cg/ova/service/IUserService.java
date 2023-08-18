package com.cg.ova.service;

import com.cg.ova.exception.LoginFailedException;
import com.cg.ova.exception.UserNotFoundException;
import com.cg.ova.model.UserModel;

public interface IUserService {
	/* definition of validUser method for validate new user */
	public UserModel validateUser(Long userId, String password)throws LoginFailedException, UserNotFoundException;
	
	/* definition of viewUser method for view user by id */
	public UserModel viewUser(Long userId)throws UserNotFoundException;
}
