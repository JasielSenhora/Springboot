package com.example.app.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.ExpensesModel;
import com.example.app.repository.ExpensesRepo;

@Service
public class ExpensesService {
   
	@Autowired
	ExpensesRepo erepo;
	
	//post the data
	  public String saveExpDetails(ExpensesModel a1) {
		   erepo.save(a1);
		   return "data saved";
	  }
	  
	  //get the data
	  public List<ExpensesModel> getExpDetails(){
		  return erepo.findAll();
	  }
	  
	  //put the data
	  public ExpensesModel updateExpDetails(ExpensesModel a2){
		  return erepo.saveAndFlush(a2);
	  }
	  
	//delete expenses if id is present
	  public boolean deleteExpif(Long id) {
		  if(erepo.existsById(id)) {
			  erepo.deleteById(id);
			  return true;
		  }
		  return false;
	  }
	  
}

