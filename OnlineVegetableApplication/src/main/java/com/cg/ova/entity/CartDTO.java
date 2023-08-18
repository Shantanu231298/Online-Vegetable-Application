package com.cg.ova.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Entity Class

@Entity
@Table(name="cart")
public class CartDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/* All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name="cart_id", length=19)
	private Long cartId;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customers;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="cartDTO")
	private List<VegetableDTO> vegetables;
	
	
	// A default Constructor with no implementation
	public CartDTO() {
		//no implementation
	}
	
   //A Parameterized Constructor for assigning the values to private members
	public CartDTO(Long cartId, Customer customers) {
		super();
		this.cartId = cartId;
		this.customers = customers;
		
	}


  //Corresponding Getters and Setters for private members
   public Long getCartId() {
		return cartId;
	}



	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}



	public Customer getCustomer() {
		return customers;
	}



	public void setCustomer(Customer customers) {
		this.customers = customers;
	}






	public List<VegetableDTO> getVegetables() {
		return vegetables;
	}



	public void setVegetables(List<VegetableDTO> vegetables) {
		this.vegetables = vegetables;
	}
	
	
   //Corresponding hashcode and equals methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((vegetables == null) ? 0 : vegetables.hashCode());
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
		CartDTO other = (CartDTO) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		if (vegetables == null) {
			if (other.vegetables != null)
				return false;
		} else if (!vegetables.equals(other.vegetables))
			return false;
		return true;
	}
   
 //toString() method overridden here
   @Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", customer=" + customers + ", vegetables=" + vegetables + "]";
	}
	
}	