package com.example.day9.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day9.model.UserModel;
import com.example.day9.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class UserController {

	@Autowired
	UserService userv;
	
	//post mapping 
	@PostMapping("/saveUserDeatils")
	@Tag(name="Save User Details",description = "save all user details")
	public UserModel saveUserDetails(@RequestBody UserModel u11) {
		return userv.saveUserDetails(u11);
	}
	
	//get mapping
	@GetMapping("/getUserDetails")
	@Tag(name="Get User Details",description = "get all user details")
	public List<UserModel> getUserDetails(){
		return userv.getUserDetails();
	}
	
	//put mapping
	@PutMapping("/updateUserDetails")
	@Tag(name="Update User Details",description = "update user details")
    public UserModel updateUserDetails(@RequestBody UserModel u12) {
		return userv.updateUserDetails(u12);
	}
	
	//delete mapping
	@DeleteMapping("/deleteUserDetails")
	@Tag(name="Delete User Details",description = "delete user details")
	public void deleteUserDetails(int uid) {
	 userv.deleteUserDetails(uid); 
	 System.out.println("data is saved");
	}
}
