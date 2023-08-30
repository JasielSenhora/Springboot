package com.example.app.model;

import java.math.BigDecimal;
import java.sql.Date;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Transactions")
public class TransactionModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
       private  Long tid;
	
	//transaction from Account
	
	
	@Column(name="amount")
	private BigDecimal amount;
	@Column(name="transactiondate")
	private Date transactionDate;
	
	@Column(name="description")
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_user_id")
	private UserModel user;

	//getters and setters
	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	

	
	
	
}
