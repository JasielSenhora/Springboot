package com.example.day6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day6.model.ChildModel;
import com.example.day6.service.ChildService;

@RestController
public class ChildController {
       @Autowired
       ChildService cserv;
       
       //post mapping
       @PostMapping("/saveDetails")
       public String SaveDetails(@RequestBody ChildModel c11) {
    	   cserv.saveChildDetails(c11);
    	   return "Data is saved";
       }
       
       //sort by asc
       @GetMapping("/sortasc/{name}")
       public List<ChildModel> sortAsc(@PathVariable("name") String name){
    	  return cserv.sortByAsc(name);
       }
       
       //sort by desc
       @GetMapping("/sortdesc/{name}")
       public List<ChildModel> sortDesc(@PathVariable ("name") String name){
    	   return cserv.sortByDesc(name);
       }
       
       //pagination
       @GetMapping("/pagination/{num}/{size}")
    	   public List<ChildModel> pagination(@PathVariable ("num") int pageNo,@PathVariable ("size") int size){
    		   return cserv.pagination(pageNo, size);
    	   }
       
       //pagination and sorting
       @GetMapping("/paginationAndSorting/{num}/{size}/{name}")
       public List<ChildModel> paginationAndSorting(@PathVariable ("num") int pageNo,@PathVariable ("size") int pageSize,@PathVariable ("name") String babyFirstName){
    	   return cserv.paginationAndSorting(pageNo, pageSize, babyFirstName);
       }
  }



