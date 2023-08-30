package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.model.CategoryModel;

public interface CategoryRepo extends JpaRepository<CategoryModel, Long>{

}
