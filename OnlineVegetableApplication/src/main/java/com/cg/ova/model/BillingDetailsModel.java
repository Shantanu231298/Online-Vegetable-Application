package com.cg.ova.model;

import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

//Model Calss
public class BillingDetailsModel {
	
	@NotNull(message="Billing Id cannot be null")
	@NotEmpty(message="Billing Id cannot be Empty ")
	private Long billingId;
	
	
	
	@NotNull(message="Transaction Mode cannot be null")
	@NotEmpty(message="Transaction Mode  cannot be Empty ")
	private String transactionMode;
	
	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message = "join date cannot be a future date")
	private LocalDateTime transactionDate;
	
	@NotNull(message="Transaction Status cannot be null")
	@NotEmpty(message="Transaction Status cannot be Empty ")
	private String tranactionStatus;
	
	@NotNull(message="Order Id cannot be null")
	@NotEmpty(message="Order Id cannot be Empty ")
	private OrderModel order;
	
	public BillingDetailsModel() {
		//noimplematTIONn
	}


	


	public BillingDetailsModel(
			@NotNull(message = "Billing Id cannot be null") @NotEmpty(message = "Billing Id cannot be Empty ") Long billingId,
			@NotNull(message = "Transaction Mode cannot be null") @NotEmpty(message = "Transaction Mode  cannot be Empty ") String transactionMode,
			@PastOrPresent(message = "join date cannot be a future date") LocalDateTime transactionDate,
			@NotNull(message = "Transaction Status cannot be null") @NotEmpty(message = "Transaction Status cannot be Empty ") String tranactionStatus,
			@NotNull(message = "Order Id cannot be null") @NotEmpty(message = "Order Id cannot be Empty ") OrderModel order) {
		super();
		this.billingId = billingId;
		this.transactionMode = transactionMode;
		this.transactionDate = transactionDate;
		this.tranactionStatus = tranactionStatus;
		this.order = order;
	}





	public Long getBillingId() {
		return billingId;
	}


	public void setBillingId(Long billingId) {
		this.billingId = billingId;
	}


	public OrderModel getOrder() {
		return order;
	}


	public void setOrder(OrderModel order) {
		this.order = order;
	}


	public String getTransactionMode() {
		return transactionMode;
	}


	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}


	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}


	public String getTranactionStatus() {
		return tranactionStatus;
	}


	public void setTranactionStatus(String tranactionStatus) {
		this.tranactionStatus = tranactionStatus;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billingId == null) ? 0 : billingId.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((tranactionStatus == null) ? 0 : tranactionStatus.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((transactionMode == null) ? 0 : transactionMode.hashCode());
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
		BillingDetailsModel other = (BillingDetailsModel) obj;
		if (billingId == null) {
			if (other.billingId != null)
				return false;
		} else if (!billingId.equals(other.billingId))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (tranactionStatus == null) {
			if (other.tranactionStatus != null)
				return false;
		} else if (!tranactionStatus.equals(other.tranactionStatus))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionMode == null) {
			if (other.transactionMode != null)
				return false;
		} else if (!transactionMode.equals(other.transactionMode))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "BillingDetailsModel [billingId=" + billingId + ", order=" + order + ", transactionMode="
				+ transactionMode + ", transactionDate=" + transactionDate + ", tranactionStatus=" + tranactionStatus
				+ "]";
	}


}
