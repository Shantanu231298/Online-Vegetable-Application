package com.cg.ova.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ova.dao.IFeedbackRepository;
import com.cg.ova.entity.Feedback;
import com.cg.ova.exception.FeedbackIdNotFoundException;
import com.cg.ova.model.FeedbackModel;
import com.cg.ova.util.EMParserFeedback;

@Service
public class FeedbackServiceImpl implements IFeedbackService {
	
    @Autowired
	private IFeedbackRepository feedbackDAO;

	@Autowired
	private EMParserFeedback parser;
	
	public FeedbackServiceImpl() {
		this.parser = new EMParserFeedback();
		
	}
    
	
	public FeedbackServiceImpl(IFeedbackRepository feedbackDAO) {
		super();
		this.feedbackDAO = feedbackDAO;
		this.parser = new EMParserFeedback();
	}

	 /* Implementation of addFeedback  to add feedback by customer */
	@Transactional
	@Override
	public FeedbackModel addFeedback(FeedbackModel feedbackModel) throws FeedbackIdNotFoundException  {
		if (feedbackModel != null) {
			if (feedbackDAO.existsById(feedbackModel.getFeedbackId())) {
				throw new FeedbackIdNotFoundException ("feedback with this id already exists");
			}

			feedbackModel = parser.parse(feedbackDAO.save(parser.parse(feedbackModel)));
		}

		return feedbackModel;
	}
		
	/* Implementation of viewFeedback  to view feedback by admin */
	@Transactional
	@Override
	public FeedbackModel viewFeedback(Long feedbackId) throws FeedbackIdNotFoundException  {
    	Feedback oldfeedback = feedbackDAO.findById(feedbackId).orElse(null);
    	System.out.println(oldfeedback);
		if (oldfeedback == null) {
			throw new FeedbackIdNotFoundException("no feedback with id #" + feedbackId + " present");
		}
		return parser.parse(feedbackDAO.findById(feedbackId).orElse(null));
	}
	
}



