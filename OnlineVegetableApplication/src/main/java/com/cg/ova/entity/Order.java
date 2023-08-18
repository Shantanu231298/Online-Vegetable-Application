package com.cg.ova.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

//Entity Class
@Entity
@Table(name="orders")
public class Order implements  Serializable {
	private static final long serialVersionUID = 1L;
	
	/* All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name="order_no")
	private Long  orderNo;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="customer_id")
	private Customer customers;
	
	@OneToMany(mappedBy="order")
	private List<VegetableDTO> vegetables;

	@Column(name="total_amount")
	private BigDecimal totalAmount;
	
	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message = "join date cannot be a future date")
	@Column(name="order_date")
	private LocalDateTime orderDate;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="status")
	private OrderStatus status;
	
	@OneToOne(mappedBy = "order")
	private BillingDetails billingDetails;
	
    // A default Constructor with no implementation
	public Order() {
		//no implementation
	}

	//A Parameterized Constructor for assigning the values to private members
	public Order(Long orderNo, Customer customers,  BigDecimal totalAmount,
			@PastOrPresent(message = "join date cannot be a future date") LocalDateTime orderDate, OrderStatus status) {
		super();
		this.orderNo = orderNo;
		this.customers = customers;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.status = status;
	}


	//Corresponding Getters and Setters for private members
	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public Customer getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

  public BigDecimal getTotalAmount() {
		return totalAmount;
	}

  public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

  public LocalDateTime getOrderDate() {
		return orderDate;
	}
  public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

 public OrderStatus getStatus() {
		return status;
	}

  public void setStatus(OrderStatus status) {
		this.status = status;
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
	result = prime * result + ((billingDetails == null) ? 0 : billingDetails.hashCode());
	result = prime * result + ((customers == null) ? 0 : customers.hashCode());
	result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
	result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
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
	Order other = (Order) obj;
	if (billingDetails == null) {
		if (other.billingDetails != null)
			return false;
	} else if (!billingDetails.equals(other.billingDetails))
		return false;
	if (customers == null) {
		if (other.customers != null)
			return false;
	} else if (!customers.equals(other.customers))
		return false;
	if (orderDate == null) {
		if (other.orderDate != null)
			return false;
	} else if (!orderDate.equals(other.orderDate))
		return false;
	if (orderNo == null) {
		if (other.orderNo != null)
			return false;
	} else if (!orderNo.equals(other.orderNo))
		return false;
	if (status != other.status)
		return false;
	if (totalAmount == null) {
		if (other.totalAmount != null)
			return false;
	} else if (!totalAmount.equals(other.totalAmount))
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
		return "Order [orderNo=" + orderNo + ", customers=" + customers + ", totalAmount=" + totalAmount
				+ ", orderDate=" + orderDate + ", status=" + status + "]";
	}

}
