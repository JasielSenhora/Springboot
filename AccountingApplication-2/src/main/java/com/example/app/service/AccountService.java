package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.app.model.AccountModel;
import com.example.app.repository.AccountRepo;

@Service
public class AccountService {
   
	@Autowired
	AccountRepo arepo;
	
	//post the data
	  public String saveAccDetails(AccountModel a1) {
		   arepo.save(a1);
		   return "data saved";
	  }
	  
	  //get the data
	  public List<AccountModel> getAccDetails(){
		  return arepo.findAll();
	  }
	  
	  //put the data
	  public AccountModel updateAccDetails(AccountModel a2){
		  return arepo.saveAndFlush(a2);
	  }
	  
	//delete account if id is present
	  public boolean deleteAccif(Long id) {
		  if(arepo.existsById(id)) {
			  arepo.deleteById(id);
			  return true;
		  }
		  return false;
	  }
	  
	  //pagination and sorting
	//sort by asc
	  public List<AccountModel> sortByAsc(String name) {
		  return arepo.findAll(Sort.by(name).ascending());
	  }
	  
	  //sort by desc
	  public List<AccountModel> sortByDesc(String name1){
		  return arepo.findAll(Sort.by(name1).descending());	 
		  }
	  
	  //pagination
	  public List<AccountModel> pagination(int pageNo,int pageSize){
		  Page <AccountModel> cont=arepo.findAll(PageRequest.of(pageNo,pageSize));
          return cont.getContent();
	  }
	  
	  //pagination and sorting
	  public List<AccountModel> paginationAndSorting(int pageNo,int pageSize,String name){
		  Page <AccountModel> cont1=arepo.findAll(PageRequest.of(pageNo,pageSize,Sort.by(name)));
		  return  cont1.getContent();
	  }
	  
}
