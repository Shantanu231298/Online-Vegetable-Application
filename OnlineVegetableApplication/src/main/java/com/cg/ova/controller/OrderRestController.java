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
import com.cg.ova.exception.OrderIdNotFoundException;
import com.cg.ova.model.OrderModel;
import com.cg.ova.service.IOrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderRestController {
	@Autowired
	private IOrderService orderService;
	
	     //add order
	     //return : order	    
	    //params : NIL
		@PostMapping
		public ResponseEntity<OrderModel> AddOrder(
				@RequestBody @Valid OrderModel orderModel, 
				BindingResult result) throws OrderIdNotFoundException {
			
			if (result.hasErrors()) {
				throw new OrderIdNotFoundException(GlobalExceptionHandler.messageFrom(result));
			}
			return ResponseEntity.ok(orderService.addOrder(orderModel));
		}
		
		//update order by id
		//return : order
	   //params : order
		@PutMapping
		public ResponseEntity<OrderModel> updateOrder(@RequestBody @Valid OrderModel orderModel) throws OrderIdNotFoundException {
			
			orderModel = orderService.updateOrder(orderModel);
			
			return new ResponseEntity<>(orderModel, HttpStatus.OK);
		}
		
		//delete order with order no
		//returns : void
		//params : order no
		@DeleteMapping
		public ResponseEntity<Boolean> CancelOrder(@PathVariable("orderNo") Long orderNo) throws OrderIdNotFoundException {
			return ResponseEntity.ok(orderService.cancelOrder(orderNo));
		}
		
		//get order with No
		//return : order
		//params : order no
		@GetMapping("/{orderNo}")
		public ResponseEntity<OrderModel> ViewOrderList(@PathVariable("orderNo") Long orderNo) throws OrderIdNotFoundException {
			ResponseEntity<OrderModel> response = null;
			OrderModel order = orderService.viewOrderList(orderNo);
			if (order == null) {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				orderService.viewOrderList(orderNo);
				response = new ResponseEntity<>(order, HttpStatus.OK);
			}
			return response;
		}
		

		

}
