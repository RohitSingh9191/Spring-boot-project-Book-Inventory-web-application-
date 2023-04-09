package com.cetpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetpa.models.BookCategory;

public interface CategoryRepository extends JpaRepository<BookCategory,Integer> 
{
}
