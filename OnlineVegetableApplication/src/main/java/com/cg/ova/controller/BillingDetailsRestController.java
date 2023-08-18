package com.cg.ova.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ova.exception.BillIdNotFoundException;
import com.cg.ova.model.BillingDetailsModel;
import com.cg.ova.service.IBillingDetailsService;



@RestController
@RequestMapping("/bill")
@CrossOrigin
public class BillingDetailsRestController {
	@Autowired
	private IBillingDetailsService billService;
	
	//add bill
	//return : bill
	//params :NIL
	@PostMapping
	public ResponseEntity<BillingDetailsModel> addBill(
			@RequestBody @Valid BillingDetailsModel billingDetailsModel, 
			BindingResult result) throws BillIdNotFoundException {
		
		if (result.hasErrors()) {
			throw new BillIdNotFoundException(GlobalExceptionHandler.messageFrom(result));
		}
		return ResponseEntity.ok(billService.addBill(billingDetailsModel));
	}
	
	   //update bill
	   //return : bill
	   //params : bill id
	   @PutMapping("/{billingId}")
	   public ResponseEntity<BillingDetailsModel> updateBill(@RequestBody @Valid BillingDetailsModel bill) throws BillIdNotFoundException {
		
		  
        bill = billService.updateBill(bill);
        
        return new ResponseEntity<>(bill, HttpStatus.OK);
	   }
	
	    //get bill with id
	    //return :bill
	    //params : bill id
		@GetMapping("/{billingId}")
		public ResponseEntity<BillingDetailsModel> viewBill(@PathVariable("billingId") Long billingId) throws BillIdNotFoundException {
		ResponseEntity<BillingDetailsModel> response = null;
		BillingDetailsModel bill = billService.viewBill(billingId);
		if (bill == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			billService.viewBill(billingId);
			response = new ResponseEntity<>(bill, HttpStatus.OK);
		}
		return response;
		
		}
	
}
