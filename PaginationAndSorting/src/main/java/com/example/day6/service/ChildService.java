package com.example.day6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.day6.model.ChildModel;
import com.example.day6.repository.ChildRepo;

@Service
public class ChildService {
	  @Autowired
       ChildRepo crepo;
	   
	  
	  //post the data
	  public String saveChildDetails(@RequestBody ChildModel c1) {
		  crepo.save(c1);
		  return "Data saved";
	  }
	  
	  //sort by asc
	  public List<ChildModel> sortByAsc(String name) {
		  return crepo.findAll(Sort.by(name).ascending());
	  }
	  
	  //sort by desc
	  public List<ChildModel> sortByDesc(String name1){
		  return crepo.findAll(Sort.by(name1).descending());	 
		  }
	  
	  //pagination
	  public List<ChildModel> pagination(int pageNo,int pageSize){
		  Page <ChildModel> cont=crepo.findAll(PageRequest.of(pageNo,pageSize));
          return cont.getContent();
	  }
	  
	  //pagination and sorting
	  public List<ChildModel> paginationAndSorting(int pageNo,int pageSize,String name){
		  Page <ChildModel> cont1=crepo.findAll(PageRequest.of(pageNo,pageSize,Sort.by(name)));
		  return  cont1.getContent();
	  }
}

