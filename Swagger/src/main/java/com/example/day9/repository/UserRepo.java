package com.example.day9.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day9.model.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer>{

}
