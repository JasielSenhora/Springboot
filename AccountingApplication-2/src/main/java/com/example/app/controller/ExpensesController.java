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

import com.example.app.model.ExpensesModel;
import com.example.app.service.ExpensesService;



@RestController
public class ExpensesController {
	 @Autowired
	 ExpensesService eserv;
     
     //post mapping
     @PostMapping("/saveExpDetails")
     public String saveExpDetails(@RequestBody ExpensesModel a11) {
     	 eserv.saveExpDetails(a11);
     	return "data is saved";
     }
     
     //get mapping
    @GetMapping("/getExpDetails")
    public List<ExpensesModel> getExpDetails(){
 	   return eserv.getExpDetails();
 	   }
    
    //put mapping
    @PutMapping("/updateExpDetails")
    public ExpensesModel updateExpDetails(@RequestBody ExpensesModel a12) {
 	   return eserv.updateExpDetails(a12);
    }
    
  //delete if id is present
    @DeleteMapping("/deleteExpbyId/{id}")
    public ResponseEntity <String> deleteExpInfo(@PathVariable Long id){
  	  boolean deleted=eserv.deleteExpif(id);
  	  if(deleted) {
  		  return ResponseEntity.ok("Expenses with Id "+id+" is deleted");
  	  }
  	  else {
  		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expenses with ID "+id+" is not found");
  	  }
    }
}

