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

import com.example.app.model.IncomeModel;
import com.example.app.service.IncomeService;


@RestController
public class IncomeController {
	 @Autowired
	 IncomeService iserv;
     
     //post mapping
     @PostMapping("/saveIncDetails")
     public String saveIncDetails(@RequestBody IncomeModel a11) {
     	 iserv.saveIncDetails(a11);
     	return "data is saved";
     }
     
     //get mapping
    @GetMapping("/getIncDetails")
    public List<IncomeModel> getIncDetails(){
 	   return iserv.getIncDetails();
 	   }
    
    //put mapping
    @PutMapping("/updateIncDetails")
    public IncomeModel updateIncDetails(@RequestBody IncomeModel a12) {
 	   return iserv.updateIncDetails(a12);
    }
    
  //delete if id is present
    @DeleteMapping("/deleteIncbyId/{id}")
    public ResponseEntity <String> deleteExpInfo(@PathVariable Long id){
  	  boolean deleted=iserv.deleteIncif(id);
  	  if(deleted) {
  		  return ResponseEntity.ok("Expenses with Id "+id+" is deleted");
  	  }
  	  else {
  		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expenses with ID "+id+" is not found");
  	  }
    }
}

