package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.app.model.CategoryModel;
import com.example.app.repository.CategoryRepo;


@Service
public class CategoryService {
   
	@Autowired
	CategoryRepo crepo;
	
	//post the data
	  public String saveCatDetails(CategoryModel a1) {
		   crepo.save(a1);
		   return "data saved";
	  }
	  
	  //get the data
	  public List<CategoryModel> getCatDetails(){
		  return crepo.findAll();
	  }
	  
	  //put the data
	  public CategoryModel updateCatDetails(CategoryModel a2){
		  return crepo.saveAndFlush(a2);
	  }
	  
	//delete category if id is present
	  public boolean deleteCatif(Long id) {
		  if(crepo.existsById(id)) {
			  crepo.deleteById(id);
			  return true;
		  }
		  return false;
	  }
	  
}

