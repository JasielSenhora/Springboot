package com.example.day4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day4.model.StudentDetails;

public interface MarksRepository extends JpaRepository <StudentDetails,Integer> {
   
}
