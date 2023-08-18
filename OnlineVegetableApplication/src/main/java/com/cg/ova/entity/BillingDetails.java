package com.cg.ova.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


    //Entity Class
    @Entity
    @Table(name="bill")
    public class BillingDetails implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/* All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name="billing_id")
	private Long billingId;
	
	@Column(name="transaction_mode")
	private String transactionMode;
	
	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message = "join date cannot be a future date")
	@Column(name="transaction_date")
	private LocalDateTime transactionDate;
	
	@Column(name="transaction_status")
	private String tranactionStatus;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="order_no")
	private Order order;
	
	// A default Constructor with no implementation
	public BillingDetails() {
		// no implementation
	}

	//A Parameterized Constructor for assigning the values to private members
	public BillingDetails(Long billingId, String transactionMode,
			@PastOrPresent(message = "join date cannot be a future date") LocalDateTime transactionDate,
			String tranactionStatus, Order order) {
		super();
		this.billingId = billingId;
		this.transactionMode = transactionMode;
		this.transactionDate = transactionDate;
		this.tranactionStatus = tranactionStatus;
		this.order = order;
	}


    //Corresponding Getters and Setters for private members
	public Long getBillingId() {
		return billingId;
	}

	public void setBillingId(Long billingId) {
		this.billingId = billingId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
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
	
	
	//Corresponding hashcode and equals methods
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
		BillingDetails other = (BillingDetails) obj;
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

  //toString() method overridden here
    @Override
	public String toString() {
		return "BillingDetails [billingId=" + billingId + ", order=" + order + ", transactionMode=" + transactionMode
				+ ", transactionDate=" + transactionDate + ", tranactionStatus=" + tranactionStatus + "]";
	}
	
	
}