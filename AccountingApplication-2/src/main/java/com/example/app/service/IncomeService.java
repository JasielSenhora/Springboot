package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.IncomeModel;
import com.example.app.repository.IncomeRepo;

@Service
public class IncomeService {
   
	@Autowired
	IncomeRepo irepo;
	
	//post the data
	  public String saveIncDetails(IncomeModel a1) {
		   irepo.save(a1);
		   return "data saved";
	  }
	  
	  //get the data
	  public List<IncomeModel> getIncDetails(){
		  return irepo.findAll();
	  }
	  
	  //put the data
	  public IncomeModel updateIncDetails(IncomeModel a2){
		  return irepo.saveAndFlush(a2);
	  }
	  
	//delete account if id is present
	  public boolean deleteIncif(Long id) {
		  if(irepo.existsById(id)) {
			  irepo.deleteById(id);
			  return true;
		  }
		  return false;
	  }
	  
}

