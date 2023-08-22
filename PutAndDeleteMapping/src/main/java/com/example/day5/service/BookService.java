package com.example.day5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day5.model.BookModel;
import com.example.day5.repository.BookRepo;

@Service
public class BookService {
	  @Autowired
      BookRepo brepo;
	  
	  //post the data
	  public BookModel saveDetails(BookModel b1) {
		  System.out.println("Details are Saved");
		  return brepo.save(b1);
	  }
	  
	  //get the data
	  public List<BookModel> getDetails(){
		  return brepo.findAll();
	  }
	  
	  //put the data
	  public BookModel updateDetails(BookModel b2){
		  return brepo.saveAndFlush(b2);
	  }
	  
	  //delete the data
	  public  void deleteDetails(int bookId){
		  brepo.deleteById(bookId);
	  }
	  
	  //delete book if id is present
	  public boolean deleteBookif(int bookId) {
		  if(brepo.existsById(bookId)) {
			  brepo.deleteById(bookId);
			  return true;
		  }
		  return false;
	  }
	  
	
	  //get mapping using id
	  public Optional<BookModel> getUserId(int id){
			Optional<BookModel>hp=brepo.findById(id);
			if(hp.isPresent()) {
				return hp;
			}
			return null;
		
		}
	  
	//update if id is present
		public boolean updateBookInfo(int studId)
		{
			if(brepo.existsById(studId))
			{
				return true;
			}
			return false;
		}
	  
	 
	  
}
