package com.cg.ova.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ova.exception.AdminIdNotFoundException;
import com.cg.ova.model.AdminModel;
import com.cg.ova.service.IAdminService;


@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminRestController {
	@Autowired
	private IAdminService adminService;
	

	  //add admin 
	  //return : admin details
	  //params : NIL 
	  @PostMapping
	  public ResponseEntity<AdminModel> addAdmin(
			@RequestBody @Valid AdminModel adminModel, 
			BindingResult result) throws AdminIdNotFoundException {
		
		if (result.hasErrors()) {
			throw new AdminIdNotFoundException(GlobalExceptionHandler.messageFrom(result));
		}
		return ResponseEntity.ok(adminService.addAdmin(adminModel));
	}
	
	    //update admin details
	    //return : admin details
	    // params :admin id
		@PutMapping("/{adminId}")
		public ResponseEntity<AdminModel> updateAdmin(
				
				@RequestBody @Valid AdminModel adminModel, 
				BindingResult result) throws AdminIdNotFoundException {
		        adminModel = adminService.updateAdminDetails(adminModel);
		        return new ResponseEntity<>(adminModel, HttpStatus.OK);
		}
	
		//delete admin by id
		//return : void
		//params : admin id
	   @DeleteMapping("/remove/{adminId}")
       public ResponseEntity<Boolean> RemoveAdmin(@PathVariable("adminId") Long adminId) throws AdminIdNotFoundException {
	   return ResponseEntity.ok(adminService.removeAdmin(adminId));
	}
	
	
	   //get admin with id
	   //return : admin details
	   //params: admin id
		@GetMapping("/{adminId}")
		public ResponseEntity<AdminModel> viewAdmin(@PathVariable("adminId") Long adminId) throws AdminIdNotFoundException {
			ResponseEntity<AdminModel> response = null;
			AdminModel adminModel = adminService.viewAdmin(adminId);
			if (adminModel == null) {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				adminService.viewAdmin(adminId);
				response = new ResponseEntity<>(adminModel, HttpStatus.OK);
			}
			return response;
		}

}