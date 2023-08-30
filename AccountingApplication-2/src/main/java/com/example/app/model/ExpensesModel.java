package com.example.app.model;

import java.math.BigDecimal;
import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Expenses")
public class ExpensesModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long eid;
    
	@Column(name="amount")
	private BigDecimal amount;
	@Column(name="expensedate")
	private Date expenseDate;
	
	//getters and setters
	public Long getEid() {
		return eid;
	}
	public void setEid(Long eid) {
		this.eid = eid;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}
	
	
	
}
