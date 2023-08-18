package com.cg.ova.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import com.cg.ova.entity.OrderStatus;

//Model Class
public class OrderModel {
	
	
	@NotNull(message="Order no cannot be null")
	@NotEmpty(message="Order No cannot be Empty")
	private Long orderNo;
	
	@NotNull(message="custId cannot be null")
	@NotEmpty(message="custtId cannot be Empty")
	private CustomerModel customer;
	

	private List<VegetableDTOModel> vegetables; 
	
	private BigDecimal totalAmount;
	
	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message = "join date cannot be a future date")
	private LocalDateTime orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	private BillingDetailsModel billingDetails;
	
	public OrderModel() {
		//no implementation
	}





	public OrderModel(
			@NotNull(message = "Order no cannot be null") @NotEmpty(message = "Order No cannot be Empty") Long orderNo,
			@NotNull(message = "custId cannot be null") @NotEmpty(message = "custtId cannot be Empty") CustomerModel customer,
			BigDecimal totalAmount,
			@PastOrPresent(message = "join date cannot be a future date") LocalDateTime orderDate, OrderStatus status) {
		super();
		this.orderNo = orderNo;
		this.customer = customer;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.status = status;
	}





	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
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
		result = prime * result + ((billingDetails == null) ? 0 : billingDetails.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
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
		OrderModel other = (OrderModel) obj;
		if (billingDetails == null) {
			if (other.billingDetails != null)
				return false;
		} else if (!billingDetails.equals(other.billingDetails))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
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

	@Override
	public String toString() {
		return "OrderModel [orderNo=" + orderNo + ", customer=" + customer + ", vegetables=" + vegetables
				+ ", totalAmount=" + totalAmount + ", orderDate=" + orderDate + ", status=" + status
				+ ", billingDetails=" + billingDetails + "]";
	}

	
}
