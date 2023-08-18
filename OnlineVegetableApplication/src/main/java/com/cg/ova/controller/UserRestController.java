package com.cg.ova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ova.exception.LoginFailedException;
import com.cg.ova.exception.UserNotFoundException;
import com.cg.ova.model.UserModel;
import com.cg.ova.service.IUserService;



@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserRestController {
	@Autowired
	private IUserService userService;
	
	//login user
	//return :user
	//params : NIL
	@PostMapping("/login")
	public ResponseEntity<UserModel> checkUserCred(@RequestBody UserModel userModel, BindingResult result) throws UserNotFoundException, LoginFailedException {
		return ResponseEntity.ok(userService.validateUser(userModel.getUserId(),userModel.getPassword()));
	}
	
	//view user
	//return : user
	//params : user Id
    @GetMapping("/{userId}")
    public ResponseEntity<UserModel> viewCustomer(@PathVariable("userId") Long userId) throws UserNotFoundException {
    ResponseEntity<UserModel> response = null;
    UserModel user = userService.viewUser(userId);
    if (user == null) {
	response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
	userService.viewUser(userId);
	response = new ResponseEntity<>(user, HttpStatus.OK);
    }
    return response;

   }

}

	
