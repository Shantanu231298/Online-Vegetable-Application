package com.cg.ova.model;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//Model Class
public class FeedbackModel {
	
	
	@NotNull(message="feedbackId cannot be null")
	@NotEmpty(message="feedbackId cannot be Empty ")
	@Id
	private Long feedbackId;
	
	@NotNull(message="custId cannot be null")
	@NotEmpty(message="custtId cannot be Empty ")
	private CustomerModel customer;
	
	@NotNull(message="Vegetable Id cannot be null")
	@NotEmpty(message="Vegetable Id cannot be Empty ")
	private VegetableDTOModel vegetableDTO;
	
	private Long rating;
	
	private String comments;
	
	public FeedbackModel() {
		//No Implementation
	}

	public FeedbackModel(
			@NotNull(message = "feedbackId cannot be null") @NotEmpty(message = "feedbackId cannot be Empty ") Long feedbackId,
			@NotNull(message = "custId cannot be null") @NotEmpty(message = "custtId cannot be Empty ") CustomerModel customer,
			@NotNull(message = "Vegetable Id cannot be null") @NotEmpty(message = "Vegetable Id cannot be Empty ") VegetableDTOModel vegetableDTO,
			Long rating, String comments) {
		super();
		this.feedbackId = feedbackId;
		this.customer = customer;
		this.vegetableDTO = vegetableDTO;
		this.rating = rating;
		this.comments = comments;
	}

	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}

	public VegetableDTOModel getVegetableDTO() {
		return vegetableDTO;
	}

	public void setVegetableDTO(VegetableDTOModel vegetableDTO) {
		this.vegetableDTO = vegetableDTO;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((feedbackId == null) ? 0 : feedbackId.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((vegetableDTO == null) ? 0 : vegetableDTO.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeedbackModel other = (FeedbackModel) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (feedbackId == null) {
			if (other.feedbackId != null)
				return false;
		} else if (!feedbackId.equals(other.feedbackId))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (vegetableDTO == null) {
			if (other.vegetableDTO != null)
				return false;
		} else if (!vegetableDTO.equals(other.vegetableDTO))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FeedbackModel [feedbackId=" + feedbackId + ", customer=" + customer + ", vegetableDTO=" + vegetableDTO
				+ ", rating=" + rating + ", comments=" + comments + "]";
	}

	

}
