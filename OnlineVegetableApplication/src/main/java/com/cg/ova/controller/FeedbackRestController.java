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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ova.exception.FeedbackIdNotFoundException;
import com.cg.ova.model.FeedbackModel;
import com.cg.ova.service.IFeedbackService;


@RestController
@RequestMapping("/feedback")
@CrossOrigin
public class FeedbackRestController {
	
	@Autowired
	private IFeedbackService feedbackService;
	
	     //add feedback
	    //return : feedback 
	    //params : NIL
		@PostMapping
		public ResponseEntity<FeedbackModel> addFeedback(
				@RequestBody @Valid FeedbackModel feedbackModel, 
				BindingResult result) throws FeedbackIdNotFoundException {
			
			if (result.hasErrors()) {
				throw new FeedbackIdNotFoundException(GlobalExceptionHandler.messageFrom(result));
			}
			return ResponseEntity.ok(feedbackService.addFeedback(feedbackModel));
		}
		
		//get feedback with id
		//return : feedback
		// params : NIL
		@GetMapping("/{feedbackId}")
		public ResponseEntity<FeedbackModel> viewFeedback(@PathVariable("feedbackId") Long feedbackId) throws FeedbackIdNotFoundException {
			ResponseEntity<FeedbackModel> response = null;
			FeedbackModel feedback = feedbackService.viewFeedback(feedbackId);
			if (feedback == null) {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				feedbackService.viewFeedback(feedbackId);
				response = new ResponseEntity<>(feedback, HttpStatus.OK);
			}
			return response;
		}

}