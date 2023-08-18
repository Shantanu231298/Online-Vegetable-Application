package com.cg.ova.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ova.dao.IUserRepository;
import com.cg.ova.entity.Role;
import com.cg.ova.entity.User;
import com.cg.ova.model.UserModel;

@Service
public class EMParserUser {
	@Autowired
	private IUserRepository userDAO;
	
	public EMParserUser() {
		//no implementation
		
	}
	
	public EMParserUser(IUserRepository userDAO) {
		super();
		this.userDAO = userDAO;
	}

	//convert user entity to user model
  public User parse(UserModel source) {
			return source==null?null:
				new User (source.getUserId(), 
						source.getPassword(),
						Role.valueOf(source.getRole()));
		}
	 
	//convert user model to user Entity
	 public UserModel  parse(User source) {
			return source==null?null:
				new UserModel(source.getUserId(),
						source.getPassword(),
						String.valueOf(source.getRole()));
		}

}
