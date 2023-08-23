package com.example.accapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accapp.model.AccountsModel;
import com.example.accapp.repository.AccountsRepo;

@Service
public class AccountsService {
	 @Autowired
     AccountsRepo arepo;
	  
	  //post the data
	  public String saveAccDetails(AccountsModel a1) {
		   arepo.save(a1);
		   return "data saved";
	  }
	  
	  //get the data
	  public List<AccountsModel> getAccDetails(){
		  return arepo.findAll();
	  }
	  
	  //put the data
	  public AccountsModel updateAccDetails(AccountsModel a2){
		  return arepo.saveAndFlush(a2);
	  }
	  
	  //delete the data
	  public  void deleteAccDetails(int id){
		  arepo.deleteById(id);
	  }
	  
	  //delete book if id is present
	  public boolean deleteAccif(int id) {
		  if(arepo.existsById(id)) {
			  arepo.deleteById(id);
			  return true;
		  }
		  return false;
	  }
	  
	
	  //get mapping using id
	  public Optional<AccountsModel> getUserId(int id){
			Optional<AccountsModel>acc=arepo.findById(id);
			if(acc.isPresent()) {
				return acc;
			}
			return null;
		
		}
	  
	//update if id is present
		public boolean updateAccInfo(int id)
		{
			if(arepo.existsById(id))
			{
				return true;
			}
			return false;
		}
	  
}
