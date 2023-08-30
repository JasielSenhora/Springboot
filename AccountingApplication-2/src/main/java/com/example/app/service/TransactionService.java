package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.app.model.TransactionModel;
import com.example.app.repository.TransactionRepo;


@Service
public class TransactionService {
   
	@Autowired
	TransactionRepo trepo;
	
	//post the data
	  public String saveTraDetails(TransactionModel a1) {
		   trepo.save(a1);
		   return "data saved";
	  }
	  
	  //get the data
	  public List<TransactionModel> getTraDetails(){
		  return trepo.findAll();
	  }
	  
	  //put the data
	  public TransactionModel updateTraDetails(TransactionModel a2){
		  return trepo.saveAndFlush(a2);
	  }
	  
	//delete account if id is present
	  public boolean deleteTraif(Long id) {
		  if(trepo.existsById(id)) {
			  trepo.deleteById(id);
			  return true;
		  }
		  return false;
	  }
	  
	  //pagination and sorting
	 
		//sort by asc
		  public List<TransactionModel> sortByAsc(String name) {
			  return trepo.findAll(Sort.by(name).ascending());
		  }
		  
		  //sort by desc
		  public List<TransactionModel> sortByDesc(String name1){
			  return trepo.findAll(Sort.by(name1).descending());	 
			  }
		  
		  //pagination
		  public List<TransactionModel> pagination(int pageNo,int pageSize){
			  Page <TransactionModel> cont=trepo.findAll(PageRequest.of(pageNo,pageSize));
	          return cont.getContent();
		  }
		  
		  //pagination and sorting
		  public List<TransactionModel> paginationAndSorting(int pageNo,int pageSize,String name){
			  Page <TransactionModel> cont1=trepo.findAll(PageRequest.of(pageNo,pageSize,Sort.by(name)));
			  return  cont1.getContent();
		  }
		  
	  
}
