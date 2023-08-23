package com.example.accapp.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.accapp.model.AccountsModel;
import com.example.accapp.service.AccountsService;
@RestController
public class AccountsController {
	 @Autowired
     AccountsService aserv;
     
     //post mapping
     @PostMapping("/saveAccDetails")
     public String saveAccDetails(@RequestBody AccountsModel a11) {
     	 aserv.saveAccDetails(a11);
     	return "data is saved";
     }
     
     //get mapping
    @GetMapping("/getAccDetails")
    public List<AccountsModel> getAccDetails(){
 	   return aserv.getAccDetails();
 	   }
    
    //put mapping
    @PutMapping("/updateAccDetails")
    public AccountsModel updateAccDetails(@RequestBody AccountsModel a12) {
 	   return aserv.updateAccDetails(a12);
    }
    
    //delete mapping using path variable
    @DeleteMapping("/deleteAcc/{id}")
    public String deleteDetailspathVar(@PathVariable("id") int aid) {
 	   aserv.deleteAccDetails(aid);
 	   return "Account with Id "+aid+" is deleted";
    }
    
    //delete mapping using Requestparam
  @DeleteMapping("/delAccbyReqParm")
  public String deleteDetailsReqpam(@RequestParam("id") int id) {
 	 aserv.deleteAccDetails(id);
 	 return "book with Id "+id+" is deleted";
  }
    
  
  //delete if id is present
   @DeleteMapping("/deleteAccbyId/{id}")
   public ResponseEntity <String> deleteBookInfo(@PathVariable int id){
 	  boolean deleted=aserv.deleteAccif(id);
 	  if(deleted) {
 		  return ResponseEntity.ok("Account with Id "+id+" is deleted");
 	  }
 	  else {
 		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account with ID "+id+" is not found");
 	  }
   }
   
   @GetMapping("/userAcc/{id}")
		public ResponseEntity<?>getUserById(@PathVariable int id){
		
			java.util.Optional<AccountsModel> book=aserv.getUserId(id);
			if(book!=null) {
				return ResponseEntity.ok(book);
			}
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account "+id+" not found");
		}
   
   @PutMapping("/upAccInfo/{id}")
	public ResponseEntity<String> updateAccDetails(@PathVariable int id)
	{
		boolean updated = aserv.updateAccInfo(id);
		if(updated)
		{
			return ResponseEntity.ok("Account with Id "+id+" updated successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account with Id "+id+" not found");
		}
	}
  
}
