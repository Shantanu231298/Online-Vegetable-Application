package com.cg.ova.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//Model Class
public class AdminModel {
	
	@NotNull(message="Customer Id cannot be null")
	@NotEmpty(message="Customer Id cannot be Empty ")
    private Long adminId;
	
	
	@NotEmpty(message = "Name cannot be empty")
	@NotNull(message = "Name cannot be null")
	private String name;
	
	@Pattern(regexp="[1-9][0-9]{9}", message="invalid mobile number")
	@NotNull(message = "Mobile Number cannot be null")
	private String contactNumber;
	
	public AdminModel() {
		//no implementation
	}

	

	public AdminModel(
			@NotNull(message = "Customer Id cannot be null") @NotEmpty(message = "Customer Id cannot be Empty ") Long adminId,
			@NotEmpty(message = "Name cannot be empty") @NotNull(message = "Name cannot be null") String name,
			@Pattern(regexp = "[1-9][0-9]{9}", message = "invalid mobile number") @NotNull(message = "Mobile Number cannot be null") String contactNumber) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.contactNumber = contactNumber;
	}



	

	
	public Long getAdminId() {
		return adminId;
	}



	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		AdminModel other = (AdminModel) obj;
		if (adminId == null) {
			if (other.adminId != null)
				return false;
		} else if (!adminId.equals(other.adminId))
			return false;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdminModel [adminId=" + adminId + ", name=" + name + ", contactNumber=" + contactNumber + "]";
	}
	
}
