package com.example.accapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accapp.model.AccountsModel;

public interface AccountsRepo extends JpaRepository<AccountsModel,Integer>{

}
