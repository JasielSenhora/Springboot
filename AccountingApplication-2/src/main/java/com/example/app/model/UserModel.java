package com.example.app.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="UserDetails")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private Long userId;
	
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_acc_id",referencedColumnName =  "userid")
	private List<AccountModel> accounts;

	//getters and setters
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AccountModel> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountModel> accounts) {
		this.accounts = accounts;
	}

	
	
	
}
