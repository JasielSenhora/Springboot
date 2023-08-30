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

import com.example.app.model.CategoryModel;
import com.example.app.service.CategoryService;


@RestController
public class CategoryController {
	 @Autowired
	 CategoryService cserv;
     
     //post mapping
     @PostMapping("/saveCatDetails")
     public String saveCatDetails(@RequestBody CategoryModel a11) {
     	 cserv.saveCatDetails(a11);
     	return "data is saved";
     }
     
     //get mapping
    @GetMapping("/getCatDetails")
    public List<CategoryModel> getCatDetails(){
 	   return cserv.getCatDetails();
 	   }
    
    //put mapping
    @PutMapping("/updateCatDetails")
    public CategoryModel updateCatDetails(@RequestBody CategoryModel a12) {
 	   return cserv.updateCatDetails(a12);
    }
    
  //delete if id is present
    @DeleteMapping("/deleteCatbyId/{id}")
    public ResponseEntity <String> deleteCatInfo(@PathVariable Long id){
  	  boolean deleted=cserv.deleteCatif(id);
  	  if(deleted) {
  		  return ResponseEntity.ok("Category with Id "+id+" is deleted");
  	  }
  	  else {
  		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category with ID "+id+" is not found");
  	  }
    }
}
