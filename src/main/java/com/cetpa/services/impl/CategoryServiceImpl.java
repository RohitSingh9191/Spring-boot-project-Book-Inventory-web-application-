package com.cetpa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.BookCategory;
import com.cetpa.repositories.CategoryRepository;
import com.cetpa.services.BookService;
import com.cetpa.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService 
{
	@Autowired private CategoryRepository repo;

	public List<BookCategory> getList() 
	{
		return repo.findAll();
	}
	public void saveRecord(BookCategory cat) 
	{
		repo.save(cat);
	}
	public void deleteRecord(int cid) 
	{
		repo.deleteById(cid);
	}
	public BookCategory getRecord(int cid) 
	{
		return repo.findById(cid).orElse(null);
	}
}
