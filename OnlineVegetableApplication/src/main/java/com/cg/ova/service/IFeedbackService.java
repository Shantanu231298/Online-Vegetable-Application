package com.cg.ova.service;

import com.cg.ova.exception.FeedbackIdNotFoundException;
import com.cg.ova.model.FeedbackModel;

public interface IFeedbackService {
	
	/* definition of addFeedback method for adding new feedback */
	public FeedbackModel addFeedback(FeedbackModel feedbackModel) throws FeedbackIdNotFoundException ;
	
	/* definition of viewfeedback method for view feedback by feedback id*/
	public FeedbackModel viewFeedback(Long feedbackId) throws FeedbackIdNotFoundException ;

}
