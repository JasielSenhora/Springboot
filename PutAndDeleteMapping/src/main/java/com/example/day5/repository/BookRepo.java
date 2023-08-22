package com.example.day5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day5.model.BookModel;

public interface BookRepo extends JpaRepository<BookModel,Integer>{

}
