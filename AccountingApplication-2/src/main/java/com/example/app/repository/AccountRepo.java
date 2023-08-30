package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.model.AccountModel;

public interface AccountRepo extends JpaRepository<AccountModel, Long>{

}
