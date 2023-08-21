package com.example.day4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day4.Repository.MarksRepository;
import com.example.day4.model.StudentDetails;

@Service
public class studentService {
	      @Autowired
          MarksRepository frepo;
	      
	      //post the data
	      public StudentDetails saveDetails(StudentDetails d) {
	    	  return frepo.save(d);
	      }
	      
	      //get the data
	      public List<StudentDetails> getDetails(){
	    	  return frepo.findAll();
	      }
}
