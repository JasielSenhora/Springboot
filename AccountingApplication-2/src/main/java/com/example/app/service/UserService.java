package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.UserModel;
import com.example.app.repository.UserRepo;


@Service
public class UserService {
   
	@Autowired
	UserRepo urepo;
	
	//post the data
	  public String saveUserDetails(UserModel a1) {
		   urepo.save(a1);
		   return "data saved";
	  }
	  
	  //get the data
	  public List<UserModel> getUserDetails(){
		  return urepo.findAll();
	  }
	  
	  //put the data
	  public UserModel updateUserDetails(UserModel a2){
		  return urepo.saveAndFlush(a2);
	  }
	  
	//delete account if id is present
	  public boolean deleteUserif(Long id) {
		  if(urepo.existsById(id)) {
			  urepo.deleteById(id);
			  return true;
		  }
		  return false;
	  }
	  
	  //getbyid and name by sql
	  public List<UserModel> getAllrows(int i,String s)
	    {
	    	return urepo.getAllRows(i,s);
	    }
	  
	    //deletebyid by sql
	  public int delUserInfo(int uid) {
		  return urepo.deleteUserInfo(uid);
	  }
	  
	  //updated by sql
	  public int updateUser(int id,int id1) {
		  return urepo.updateUserInfo(id, id1);
	  }
	  
}

