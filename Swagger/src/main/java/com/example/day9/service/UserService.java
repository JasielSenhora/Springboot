package com.example.day9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.day9.model.UserModel;
import com.example.day9.repository.UserRepo;

@Service
public class UserService {
	@Autowired
    UserRepo urepo;
	
	//save the data
	public UserModel saveUserDetails(@RequestBody UserModel u1) {
		return urepo.save(u1);
	}
	
	//get the data
	public List<UserModel> getUserDetails(){
		return urepo.findAll();
	}
	
	//put the data
	public UserModel updateUserDetails(@RequestBody UserModel u2) {
		return urepo.saveAndFlush(u2);
	}
	
	//delete the data
	public void deleteUserDetails(int uid) {
		urepo.deleteById(uid);
		System.out.println("data is deleted");
	}

}
