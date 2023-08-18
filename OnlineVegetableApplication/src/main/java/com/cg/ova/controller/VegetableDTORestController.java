package com.cg.ova.controller;

import java.util.List;
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
import com.cg.ova.exception.VegetableIdNotFoundException;
import com.cg.ova.model.VegetableDTOModel;
import com.cg.ova.service.IVegetableDTOService;

@RestController
@RequestMapping("/veg")
@CrossOrigin
public class VegetableDTORestController {
	@Autowired
	private IVegetableDTOService vegService;
	
	      //add vegetable
	     //return : vegetable
	    //params : NIL
		@PostMapping
		public ResponseEntity<VegetableDTOModel> addVegetable(
				@RequestBody @Valid VegetableDTOModel vegetableDTOModel, 
				BindingResult result) throws VegetableIdNotFoundException {
			
			if (result.hasErrors()) {
				throw new VegetableIdNotFoundException(GlobalExceptionHandler.messageFrom(result));
			}
			return ResponseEntity.ok(vegService.addVegetable(vegetableDTOModel));
		}
		
		//update vegetable by id
		//return : vegetable
		//params : Veg
		
		@PutMapping
		public ResponseEntity<VegetableDTOModel> updateVegetable(
				@RequestBody @Valid VegetableDTOModel vegetableDTOModel 
				) throws VegetableIdNotFoundException {
			
			        
			        vegetableDTOModel = vegService.updateVegetable(vegetableDTOModel);
			        
			        return new ResponseEntity<>(vegetableDTOModel, HttpStatus.OK);
			    }
		
		
		//delete vegetable with id
		//return : void
		//params : veg id
		@DeleteMapping
		public ResponseEntity<Boolean> Removevegetable(@PathVariable("vegId") Long vegId) 
				throws VegetableIdNotFoundException {
			return ResponseEntity.ok(vegService.removeVegetable(vegId));
		}
		
		//get vegetable with id
		//return : vegetables
		//params : veg id
		 @GetMapping("/{vegId}")
		 public ResponseEntity<VegetableDTOModel> viewVegetable(@PathVariable("vegId") Long vegId) throws VegetableIdNotFoundException{
			ResponseEntity<VegetableDTOModel> response = null;
			VegetableDTOModel veg = vegService.viewVegetable(vegId);
			if (veg == null) {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				vegService.viewVegetable(vegId);
				response = new ResponseEntity<>(veg, HttpStatus.OK);
			}
			return response;
			
			}
		
		
		 //get vegetable with type
		 //return : vegetables
	     //params : type
		 @GetMapping
		 public ResponseEntity<List<VegetableDTOModel>> viewVegetableList(@PathVariable("type") String type) 
						throws VegetableIdNotFoundException {
					return ResponseEntity.ok(vegService.viewVegetableList(type));
				}
				

}
