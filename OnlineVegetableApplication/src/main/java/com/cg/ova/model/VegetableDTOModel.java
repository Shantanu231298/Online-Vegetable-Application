package com.cg.ova.model;

import java.math.BigInteger;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//Model Class
public class VegetableDTOModel {
	
	@NotNull(message="veg Id cannot be null")
	@NotEmpty(message="Veg Id cannot be Empty ")
	private Long vegId;
	
	private String name;
	private String type;
	
	private BigInteger price;
	
	private int quantity;
	
	@NotEmpty(message = "Cart cannot be empty")
	@NotNull(message = "Cart cannot be omitted")
	private CartDTOModel cartDTO;
	
	@NotEmpty(message = "order cannot be empty")
	@NotNull(message = "order cannot be omitted")
	private OrderModel order;
	
	@NotEmpty(message = "feedback cannot be empty")
	@NotNull(message = "feedback cannot be omitted")
	private FeedbackModel feedback;
	
	public VegetableDTOModel() {
		//no implementation
	}


public VegetableDTOModel(
			@NotNull(message = "veg Id cannot be null") @NotEmpty(message = "Veg Id cannot be Empty ") Long vegId,
			String name, String type, BigInteger price, int quantity) {
		super();
		this.vegId = vegId;
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}


   public Long getVegId() {
		return vegId;
	}

	public void setVegId(Long vegId) {
		this.vegId = vegId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public  BigInteger getPrice() {
		return price;
	}

	public void setPrice( BigInteger price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartDTO == null) ? 0 : cartDTO.hashCode());
		result = prime * result + ((feedback == null) ? 0 : feedback.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((vegId == null) ? 0 : vegId.hashCode());
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
		VegetableDTOModel other = (VegetableDTOModel) obj;
		if (cartDTO == null) {
			if (other.cartDTO != null)
				return false;
		} else if (!cartDTO.equals(other.cartDTO))
			return false;
		if (feedback == null) {
			if (other.feedback != null)
				return false;
		} else if (!feedback.equals(other.feedback))
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
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (vegId == null) {
			if (other.vegId != null)
				return false;
		} else if (!vegId.equals(other.vegId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VegetableDTOModel [vegId=" + vegId + ", name=" + name + ", type=" + type + ", price=" + price
				+ ", quantity=" + quantity + ", cartDTO=" + cartDTO + ", order=" + order + "]";
	}

	
}