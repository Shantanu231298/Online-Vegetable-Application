package com.cg.ova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ova.exception.CartIdNotFoundException;
import com.cg.ova.exception.VegetableIdNotFoundException;
import com.cg.ova.model.CartDTOModel;
import com.cg.ova.model.VegetableDTOModel;
import com.cg.ova.service.ICartDTOService;


@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartDTORestController {
	
	@Autowired
	private ICartDTOService cartService;
	
	//get cart with id
    //return  single cart details
    @GetMapping("/{cartId}")
    public ResponseEntity<CartDTOModel> viewCustomer(@PathVariable("cartId") Long cartId) throws CartIdNotFoundException {
    ResponseEntity<CartDTOModel> response = null;
    CartDTOModel cart = cartService.viewCart(cartId);
    if (cart == null) {
        response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
        cartService.viewCart(cartId);
        response = new ResponseEntity<>(cart, HttpStatus.OK);
    }
    return response;
    
    }
	
	
	//add cart
	//return : cart
	//params : veg
	@PostMapping
   public ResponseEntity<CartDTOModel>addToCart(@RequestBody CartDTOModel cart,VegetableDTOModel veg)throws CartIdNotFoundException{
		cart = cartService.addToCart(cart, veg);
		return new ResponseEntity<>(cart, HttpStatus.CREATED);
	}



    //removeVegetable
	@DeleteMapping
	public ResponseEntity<Boolean> RemoveVegetable(@PathVariable("cartId") Long cartId ,@PathVariable("vegId") Long vegId) throws VegetableIdNotFoundException, CartIdNotFoundException {
		return ResponseEntity.ok(cartService.removeVeg(vegId));
	

}

   // increaseVegQuantity
   /*@PutMapping("/updateinc/{cartId}/{vegId}/{quantity}")
	public ResponseEntity<CartDTOModel> increaseVegQuantity(@PathVariable("cartId") Long cartid, @PathVariable("vegId")Long vegId,@PathVariable("quantity")int quantity)throws VegetableIdNotFoundException, CartIdNotFoundException {
		return ResponseEntity.ok(cartService.increaseVegQuantity(vegId,quantity));
	}
	*/
	
	/*//decreaseVegQuantity
	@PutMapping("/updatedec/{cartId}/{vegId}/{quantity}")
	/*public ResponseEntity<CartDTOModel> decreaseVegQuantity(@PathVariable("cartId") Long cartid, @PathVariable("vegId")Long vegId,@PathVariable("quantity")int quantity)throws VegetableIdNotFoundException, CartIdNotFoundException {
		return ResponseEntity.ok(cartService.decreaseVegQuantity(vegId,quantity));
	}*/
	
	//viewAllItems
	/*@GetMapping("{cartId}")
	public ResponseEntity<List<CartDTOModel>> viewAllItems() throws CartIdNotFoundException {
		 return new ResponseEntity<>(cartService.viewAllItems(), HttpStatus.OK);
		
	}*/
	

	
	//removeAllItems
	/*
	@DeleteMapping("/remove/{cartId}")
	public ResponseEntity <Boolean> removeAllVegetable (@RequestBody CartDTOModel cart)throws CartIdNotFoundException {
		return ResponseEntity.ok(cartService.removeAll());
	}*/
	
	
}