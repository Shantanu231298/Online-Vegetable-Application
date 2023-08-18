package com.cg.ova.service;


import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ova.dao.IUserRepository;
import com.cg.ova.entity.User;
import com.cg.ova.exception.LoginFailedException;
import com.cg.ova.exception.UserNotFoundException;
import com.cg.ova.model.UserModel;
import com.cg.ova.util.EMParserUser;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserRepository userDAO;
	@Autowired
	private EMParserUser parser;
	
	public UserServiceImpl() {
		this.parser = new EMParserUser();
		
	}
	
	
   public UserServiceImpl(IUserRepository userDAO) {
		super();
		this.userDAO = userDAO;
		this.parser = new EMParserUser();
	}
   
   /* Implementation of validateUser  to validate all the users */
   @Transactional
	@Override
	public UserModel validateUser(Long userId, String password) throws LoginFailedException, UserNotFoundException {
	   if(!userDAO.existsByUserId(userId)){
			throw new UserNotFoundException("User Not present in DB.");
		}
		
		UserModel userFromDb = parser.parse(userDAO.findByUserId(userId));
		
		if(!userFromDb.getPassword().equals(password)) {
			throw new LoginFailedException("Username / Password is wrong.");
		}

		
		return userFromDb;
		 
	
	 
		}
   
   /* Implementation of viewUser  to view all the users by id */
   @Transactional
 	@Override
 	public UserModel viewUser(Long userId) throws UserNotFoundException {
     	User oldUser = userDAO.findById(userId).orElse(null);
 		if (oldUser == null) {
 			throw new UserNotFoundException("no user with id #" + userId + " present");
 		}
 		return parser.parse(userDAO.findById(userId).orElse(null));
 	}


}
