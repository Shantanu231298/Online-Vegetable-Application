package com.cg.ova.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


//model class
public class UserModel {
	
	
	@NotNull(message="Customer Id cannot be null")
	@NotEmpty(message="Customer Id cannot be Empty ")
	private Long userId;
	
	@Pattern(regexp="[a-zA-Z0-9 @_]{8,20}", message="invalid password")
	@NotNull(message="paswsword cannot be null")
	private String password;

	
	private String role;
	
	public UserModel() {
		//no implementation
	}

	public UserModel(
			@NotNull(message = "Customer Id cannot be null") @NotEmpty(message = "Customer Id cannot be Empty ") Long userId,
			@Pattern(regexp = "[a-zA-Z0-9 @_]{8,20}", message = "invalid password") @NotNull(message = "paswsword cannot be null") String password,
			String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		UserModel other = (UserModel) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}

	
}
