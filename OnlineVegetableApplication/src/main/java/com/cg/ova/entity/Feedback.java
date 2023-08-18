package com.cg.ova.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Entity Class
@Entity
@Table(name="feedback")
public class Feedback implements  Serializable{
	private static final long serialVersionUID = 1L;
	
	/* All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name="feedback_id")
	private Long feedbackId;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customers;
	
	@OneToOne
	@JoinColumn(name="veg_id")
	private VegetableDTO vegetableDTO;
	
	@Column(name="rating")
	private Long rating;
	
	@Column(name="comments")
	private String comments;
	
	// A default Constructor with no implementation
	public Feedback() {
		//no implementation
	}
	
	//A Parameterized Constructor for assigning the values to private members
	public Feedback(Long feedbackId, Customer customer, VegetableDTO vegetableDTO, Long rating, String comments) {
		super();
		this.feedbackId = feedbackId;
		this.customers = customer;
		this.vegetableDTO = vegetableDTO;
		this.rating = rating;
		this.comments = comments;
	}
	
	//Corresponding Getters and Setters for private members
	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Customer getCustomer() {
		return customers;
	}

	public void setCustomer(Customer customer) {
		this.customers = customer;
	}

	public VegetableDTO getVegetableDTO() {
		return vegetableDTO;
	}

	public void setVegetableDTO(VegetableDTO vegetableDTO) {
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
	
	
	//Corresponding hashcode and equals methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
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
		Feedback other = (Feedback) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
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
	
	//toString() method overridden here
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", customer=" + customers + ", vegetableDTO=" + vegetableDTO
				+ ", rating=" + rating + ", comments=" + comments + "]";
	}
	
}
