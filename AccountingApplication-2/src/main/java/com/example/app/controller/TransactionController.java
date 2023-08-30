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


import com.example.app.model.TransactionModel;
import com.example.app.service.TransactionService;



@RestController
public class TransactionController {
	 @Autowired
	 TransactionService tserv;
     
     //post mapping
     @PostMapping("/saveTraDetails")
     public String saveTraDetails(@RequestBody  TransactionModel a11) {
     	 tserv.saveTraDetails(a11);
     	return "data is saved";
     }
     
     //get mapping
    @GetMapping("/getTraDetails")
    public List< TransactionModel> getTraDetails(){
 	   return tserv.getTraDetails();
 	   }
    
    //put mapping
    @PutMapping("/updateTraDetails")
    public  TransactionModel updateTraDetails(@RequestBody  TransactionModel a12) {
 	   return tserv.updateTraDetails(a12);
    }
    
  //delete if id is present
    @DeleteMapping("/deleteTrabyId/{id}")
    public ResponseEntity <String> deleteTraInfo(@PathVariable Long id){
  	  boolean deleted=tserv.deleteTraif(id);
  	  if(deleted) {
  		  return ResponseEntity.ok(" Transaction with Id "+id+" is deleted");
  	  }
  	  else {
  		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Transaction with ID "+id+" is not found");
  	  }
    }
    
    //pagination and sorting
    //sort by asc
    @GetMapping("/sortascTra/{name}")
    public List<TransactionModel> sortAsc(@PathVariable("name") String name){
 	  return tserv.sortByAsc(name);
    }
    
    //sort by desc
    @GetMapping("/sortdescTra/{name}")
    public List<TransactionModel> sortDesc(@PathVariable ("name") String name){
 	   return tserv.sortByDesc(name);
    }
    
    //pagination
    @GetMapping("/paginationTra/{num}/{size}")
 	   public List<TransactionModel> pagination(@PathVariable ("num") int pageNo,@PathVariable ("size") int size){
 		   return tserv.pagination(pageNo, size);
 	   }
    
    //pagination and sorting
    @GetMapping("/paginationAndSortingTra/{num}/{size}/{name}")
    public List<TransactionModel> paginationAndSorting(@PathVariable ("num") int pageNo,@PathVariable ("size") int pageSize,@PathVariable ("name") String babyFirstName){
 	   return tserv.paginationAndSorting(pageNo, pageSize, babyFirstName);
    }
}

