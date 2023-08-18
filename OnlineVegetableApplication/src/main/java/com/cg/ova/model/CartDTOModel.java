package com.cg.ova.model;

import java.util.List;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//Model Class
public class CartDTOModel {
	
	@NotNull(message="cartId cannot be null")
	@NotEmpty(message="cartId cannot be Empty ")
	private Long cartId;
	
	@NotNull(message="custId cannot be null")
	@NotEmpty(message="custtId cannot be Empty ")
	private CustomerModel customers;
	
	@OneToMany(mappedBy="cartDTO")
	private List<VegetableDTOModel> vegetables;
	
	
	public CartDTOModel() {
		//no implementation
	}


	public CartDTOModel(
			@NotNull(message = "cartId cannot be null") @NotEmpty(message = "cartId cannot be Empty ") Long cartId,
			@NotNull(message = "custId cannot be null") @NotEmpty(message = "custtId cannot be Empty ") CustomerModel customers) {
		super();
		this.cartId = cartId;
		this.customers = customers;
		
	}





	public Long getCartId() {
		return cartId;
	}


	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}


	public CustomerModel getCustomer() {
		return customers;
	}


	public void setCustomer(CustomerModel customers) {
		this.customers = customers;
	}


	public List<VegetableDTOModel> getVegetables() {
		return vegetables;
	}


	public void setVegetables(List<VegetableDTOModel> vegetables) {
		this.vegetables = vegetables;
	}
	
	


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
		CartDTOModel other = (CartDTOModel) obj;
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


	@Override
	public String toString() {
		return "CartDTOModel [cartId=" + cartId + ", customers=" + customers + ", vegetables=" + vegetables
				+ "]";
	}


}
