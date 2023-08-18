package com.cg.ova.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ova.entity.Feedback;

@Repository
public interface IFeedbackRepository  extends JpaRepository<Feedback, Long>{

	//method to check whether a billing id exists
	boolean existsByFeedbackId(Long feedbackId);
	
	//method to find feedback by feedback id
	Feedback findByFeedbackId(Long feedbackId);
	
	
}
