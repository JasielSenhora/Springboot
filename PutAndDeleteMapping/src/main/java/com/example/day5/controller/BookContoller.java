package com.example.day5.controller;

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

import com.example.day5.model.BookModel;
import com.example.day5.service.BookService;


@RestController
public class BookContoller {
        @Autowired
        BookService bserv;
        
        //post mapping
        @PostMapping("/saveDetails")
        public BookModel saveDetails(@RequestBody BookModel b11) {
        	return bserv.saveDetails(b11);
        }
        
        //get mapping
       @GetMapping("/getDetails")
       public List<BookModel> getDetails(){
    	   return bserv.getDetails();
    	   }
       
       //put mapping
       @PutMapping("/updateDetails")
       public BookModel updateDetails(@RequestBody BookModel b12) {
    	   return bserv.updateDetails(b12);
       }
       
       //delete mapping using path variable
       @DeleteMapping("/delete/{id}")
       public String deleteDetailspathVar(@PathVariable("id") int bid) {
    	   bserv.deleteDetails(bid);
    	   return "Book with Id "+bid+" is deleted";
       }
       
       //delete mapping using Requestparam
     @DeleteMapping("/delbyReqParm")
     public String deleteDetailsReqpam(@RequestParam("id") int id) {
    	 bserv.deleteDetails(id);
    	 return "book with Id "+id+" is deleted";
     }
       
     
     //delete if id is present
      @DeleteMapping("/deletebyId/{id}")
      public ResponseEntity <String> deleteBookInfo(@PathVariable int id){
    	  boolean deleted=bserv.deleteBookif(id);
    	  if(deleted) {
    		  return ResponseEntity.ok("Book with Id "+id+" is deleted");
    	  }
    	  else {
    		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with ID "+id+" is not found");
    	  }
      }
      
      @GetMapping("/user/{id}")
		public ResponseEntity<?>getUserById(@PathVariable int id){
		
			java.util.Optional<BookModel> book=bserv.getUserId(id);
			if(book!=null) {
				return ResponseEntity.ok(book);
			}
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book "+id+" not found");
		}
      
      @PutMapping("/upBookInfo/{id}")
  	public ResponseEntity<String> updateBookDetails(@PathVariable int id)
  	{
  		boolean updated = bserv.updateBookInfo(id);
  		if(updated)
  		{
  			return ResponseEntity.ok("Book with Id "+id+" updated successfully");
  		}
  		else {
  			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with Id "+id+" not found");
  		}
  	}
     
}
