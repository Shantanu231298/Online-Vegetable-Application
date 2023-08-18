package com.cg.ova.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Entity Class
@Entity
@Table(name="admin")
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/* All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name="admin_id")
	private Long adminId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="contact_number")
	private String contactNumber;
	
	// A default Constructor with no implementation
	public Admin() {
		//no implementation
	}
	
    //A Parameterized Constructor for assigning the values to private members
	public Admin(Long adminId, String name, String contactNumber) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.contactNumber = contactNumber;
	}

	//Corresponding Getters and Setters for private members
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
	
	//Corresponding hashcode and equals methods
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
		Admin other = (Admin) obj;
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
    
	//toString() method overridden here
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", contactNumber=" + contactNumber + "]";
	}
	
}
