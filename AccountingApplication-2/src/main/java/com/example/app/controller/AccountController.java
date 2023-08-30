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

import com.example.app.model.AccountModel;
import com.example.app.service.AccountService;



@RestController
public class AccountController {
	 @Autowired
     AccountService aserv;
     
     //post mapping
     @PostMapping("/saveAccDetails")
     public String saveAccDetails(@RequestBody AccountModel a11) {
     	 aserv.saveAccDetails(a11);
     	return "data is saved";
     }
     
     //get mapping
    @GetMapping("/getAccDetails")
    public List<AccountModel> getAccDetails(){
 	   return aserv.getAccDetails();
 	   }
    
    //put mapping
    @PutMapping("/updateAccDetails")
    public AccountModel updateAccDetails(@RequestBody AccountModel a12) {
 	   return aserv.updateAccDetails(a12);
    }
    
  //delete if id is present
    @DeleteMapping("/deleteAccbyId/{id}")
    public ResponseEntity <String> deleteAccInfo(@PathVariable Long id){
  	  boolean deleted=aserv.deleteAccif(id);
  	  if(deleted) {
  		  return ResponseEntity.ok("Account with Id "+id+" is deleted");
  	  }
  	  else {
  		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account with ID "+id+" is not found");
  	  }
    }
    

    //pagination and sorting
    //sort by asc
    @GetMapping("/sortascAcc/{name}")
    public List<AccountModel> sortAsc(@PathVariable("name") String name){
 	  return aserv.sortByAsc(name);
    }
    
    //sort by desc
    @GetMapping("/sortdescAcc/{name}")
    public List<AccountModel> sortDesc(@PathVariable ("name") String name){
 	   return aserv.sortByDesc(name);
    }
    
    //pagination
    @GetMapping("/paginationAcc/{num}/{size}")
 	   public List<AccountModel> pagination(@PathVariable ("num") int pageNo,@PathVariable ("size") int size){
 		   return aserv.pagination(pageNo, size);
 	   }
    
    //pagination and sorting
    @GetMapping("/paginationAndSortingAcc/{num}/{size}/{name}")
    public List<AccountModel> paginationAndSorting(@PathVariable ("num") int pageNo,@PathVariable ("size") int pageSize,@PathVariable ("name") String babyFirstName){
 	   return aserv.paginationAndSorting(pageNo, pageSize, babyFirstName);
    }
}
