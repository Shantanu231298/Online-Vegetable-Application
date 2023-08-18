package com.cg.ova.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Entity Class

@Entity
@Table(name="veg")
public class VegetableDTO implements Serializable  {
	private static final long serialVersionUID=1L;
	
	/* All the private members are defined here with suitable datatypes
	 * 
	 */
	
	@Id
	@Column(name="veg_id")
	private Long vegId;

   @Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	

	
	@Column(name="price")
	private BigInteger price;
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private CartDTO cartDTO;
	
	@ManyToOne
	@JoinColumn(name="order_no")
	private Order order;
	

	
	@OneToOne(mappedBy = "vegetableDTO")
	private Feedback feedback;
	
	
	// A default Constructor with no implementation
	public VegetableDTO() {
		//no implementation
	}

  
	//A Parameterized Constructor for assigning the values to private members
	public VegetableDTO(Long vegId, String name, String type, BigInteger price, int quantity) {
		super();
		this.vegId = vegId;
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}

	
	//Corresponding Getters and Setters for private members
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

   public BigInteger getPrice() {
		return price;
	}

  public void setPrice(BigInteger price) {
		this.price = price;
	}

   public int getQuantity() {
		return quantity;
	}
   
   public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

   public CartDTO getCartDTO() {
		return cartDTO;
	}
    public void setCartDTO(CartDTO cartDTO) {
		this.cartDTO = cartDTO;
	}

   public Order getOrder() {
		return order;
	}

    public void setOrder(Order order) {
		this.order = order;
	}

  //Corresponding hashcode and equals methods
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
		VegetableDTO other = (VegetableDTO) obj;
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

  //toString() method overridden here
   @Override
	public String toString() {
		return "VegetableDTO [vegId=" + vegId + ", name=" + name + ", type=" + type + ", price=" + price + ", quantity="
				+ quantity + ", cartDTO=" + cartDTO + ", order=" + order + "]";
	}



	
	
}