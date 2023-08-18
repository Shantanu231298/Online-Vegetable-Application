package com.cg.ova.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

//Entity Class

@Entity
@Table(name="users")
public class User  implements  Serializable{
	private static final long serialVersionUID = 1L;
	
	/* All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name="user_id")
	private Long userId;
	
	private String password;

	@Enumerated(value=EnumType.STRING)
	private Role role;
	
	 // A default Constructor with no implementation
	public User() {
		//no implementation
	}

	//A Parameterized Constructor for assigning the values to private members
	public User(Long userId, String password, Role role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}
    
	//Corresponding Getters and Setters for private members
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	//Corresponding hashcode and equals methods
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
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role != other.role)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	//toString() method overridden here
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}

	
	
}