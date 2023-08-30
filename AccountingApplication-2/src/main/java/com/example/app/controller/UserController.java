package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.UserModel;
import com.example.app.service.UserService;


@RestController
public class UserController {
	 @Autowired
	 UserService userv;
     
     //post mapping
     @PostMapping("/saveUserDetails")
     public String saveUserDetails(@RequestBody  UserModel a11) {
     	 userv.saveUserDetails(a11);
     	return "data is saved";
     }
     
     //get mapping
    @GetMapping("/getUserDetails")
    public List< UserModel> getUserDetails(){
 	   return userv.getUserDetails();
 	   }
    
    //put mapping
    @PutMapping("/updateUserDetails")
    public  UserModel updateUserDetails(@RequestBody  UserModel a12) {
 	   return userv.updateUserDetails(a12);
    }
    
  //delete if id is present
    @DeleteMapping("/deleteUserbyId/{id}")
    public ResponseEntity <String> deleteUserInfo(@PathVariable Long id){
  	  boolean deleted=userv.deleteUserif(id);
  	  if(deleted) {
  		  return ResponseEntity.ok("User with Id "+id+" is deleted");
  	  }
  	  else {
  		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID "+id+" is not found");
  	  }
    }
    
    @GetMapping("/getAllrows/{uid}/{name}")
    public List<UserModel> getAllrows(@PathVariable int uid,@PathVariable String name){
   	 return userv.getAllrows(uid,name);
    }
    
    //deleted by using sql
    @DeleteMapping("deletequery/{uid}")
    public String delUserInfo(@PathVariable int uid)
    {
    	return userv.delUserInfo(uid)+"DELETED";
    }
    
    //updated by using sql
    @PutMapping("updatequery/{newid}/{oldid}")
    public String updateUser(@PathVariable int newid,@PathVariable int oldid) {
    	return userv.updateUser(newid, oldid)+"UPDATED";
    }
}

