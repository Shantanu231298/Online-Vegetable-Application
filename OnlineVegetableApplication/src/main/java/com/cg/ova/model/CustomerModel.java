package com.cg.ova.model;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//Model Class
public class CustomerModel {
	
	@NotNull(message="Customer Id cannot be null")
	@NotEmpty(message="Customer Id cannot be Empty ")
	private Long customerId;
	
	@NotEmpty(message = "Name cannot be empty")
	@NotNull(message = "Name cannot be null")
	private String name;
	
	@Pattern(regexp="[1-9][0-9]{9}", message="invalid mobile number")
	@NotNull(message = "Mobile Number cannot be null")
	private String mobileNumber;
	
	
	
	@Pattern(regexp="^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$", message="Inalid email")
	@NotNull(message = "Email cannot be null")
	private String emailId;
	
	@Pattern(regexp="[a-zA-Z0-9 @_]{8,20}", message="invalid password")
	@NotNull(message="paswsword cannot be null")
	private String password;
	
	@Valid
	private AddressModel address;
	
	private CartDTOModel cartDTO;
	private OrderModel order;
	private FeedbackModel feedback;
	
	public CustomerModel() {
		//no implementation
	}
	
	

public CustomerModel(
			@NotNull(message = "Customer Id cannot be null") @NotEmpty(message = "Customer Id cannot be Empty ") Long customerId,
			@NotEmpty(message = "Name cannot be empty") @NotNull(message = "Name cannot be null") String name,
			@Pattern(regexp = "[1-9][0-9]{9}", message = "invalid mobile number") @NotNull(message = "Mobile Number cannot be null") String mobileNumber,
			@Pattern(regexp = "^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$", message = "Inalid email") @NotNull(message = "Email cannot be null") String emailId,
			@Pattern(regexp = "[a-zA-Z0-9 @_]{8,20}", message = "invalid password") @NotNull(message = "paswsword cannot be null") String password,
			@Valid AddressModel address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.password = password;
		this.address = address;
	}



public Long getCustomerId() {
	return customerId;
}



public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getMobileNumber() {
	return mobileNumber;
}



public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}



public String getEmailId() {
	return emailId;
}



public void setEmailId(String emailId) {
	this.emailId = emailId;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public AddressModel getAddress() {
	return address;
}



public void setAddress(AddressModel address) {
	this.address = address;
}



public CartDTOModel getCartDTO() {
	return cartDTO;
}



public void setCartDTO(CartDTOModel cartDTO) {
	this.cartDTO = cartDTO;
}



public OrderModel getOrder() {
	return order;
}



public void setOrder(OrderModel order) {
	this.order = order;
}



public FeedbackModel getFeedback() {
	return feedback;
}



public void setFeedback(FeedbackModel feedback) {
	this.feedback = feedback;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((cartDTO == null) ? 0 : cartDTO.hashCode());
	result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
	result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
	result = prime * result + ((feedback == null) ? 0 : feedback.hashCode());
	result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((order == null) ? 0 : order.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
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
	CustomerModel other = (CustomerModel) obj;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (cartDTO == null) {
		if (other.cartDTO != null)
			return false;
	} else if (!cartDTO.equals(other.cartDTO))
		return false;
	if (customerId == null) {
		if (other.customerId != null)
			return false;
	} else if (!customerId.equals(other.customerId))
		return false;
	if (emailId == null) {
		if (other.emailId != null)
			return false;
	} else if (!emailId.equals(other.emailId))
		return false;
	if (feedback == null) {
		if (other.feedback != null)
			return false;
	} else if (!feedback.equals(other.feedback))
		return false;
	if (mobileNumber == null) {
		if (other.mobileNumber != null)
			return false;
	} else if (!mobileNumber.equals(other.mobileNumber))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (order == null) {
		if (other.order != null)
			return false;
	} else if (!order.equals(other.order))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	return true;
}



@Override
public String toString() {
	return "CustomerModel [customerId=" + customerId + ", name=" + name + ", mobileNumber=" + mobileNumber
			+ ", emailId=" + emailId + ", password=" + password + ", address=" + address + ", cartDTO=" + cartDTO
			+ ", order=" + order + ", feedback=" + feedback + "]";
}

}
