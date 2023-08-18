package com.cg.ova.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ova.dao.IFeedbackRepository;
import com.cg.ova.entity.Feedback;
import com.cg.ova.model.FeedbackModel;




@Service
public class EMParserFeedback {
	public IFeedbackRepository feedbackDAO;
	
	@Autowired
	private EMParserCustomer customerParser;
	
	@Autowired
	private EMParserVegetableDTO vegetableParser;
	
	
	public EMParserFeedback() {
		this.customerParser=new EMParserCustomer();
		this.vegetableParser=new EMParserVegetableDTO();
	}
	
	
	
	 public EMParserFeedback(IFeedbackRepository feedbackDAO) {
		super();
		this.feedbackDAO = feedbackDAO;
		this.customerParser=new EMParserCustomer();
		this.vegetableParser=new EMParserVegetableDTO();
	}


	//convert feedback entity to feedback model
	public Feedback parse(FeedbackModel source) {
			return source==null?null:
				new Feedback (source.getFeedbackId(), 
						customerParser.parse(source.getCustomer()),
						vegetableParser.parse(source.getVegetableDTO()),
						source.getRating(),
						source.getComments());
		}
	 
	//convert feedback model to feedback entity
	 public FeedbackModel parse(Feedback source) {
			return source==null?null:
				new FeedbackModel (source.getFeedbackId(), 
						customerParser.parse(source.getCustomer()),
						vegetableParser.parse(source.getVegetableDTO()),
						source.getRating(),
						source.getComments());
		}

}
