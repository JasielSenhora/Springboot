package com.example.day4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day4.model.StudentDetails;
import com.example.day4.service.studentService;

@RestController
public class StudentController {
   @Autowired
   studentService sser;
   @PostMapping("/saveMarks")
   
   public StudentDetails savestudentDetails(@RequestBody StudentDetails ds) {
	   return sser.saveDetails(ds);
   }
   
   @GetMapping("/getMarks")
   public java.util.List<StudentDetails> getDetails(){
 	  return sser.getDetails();
   }
}
