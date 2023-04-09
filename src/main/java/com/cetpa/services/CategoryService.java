package com.cetpa.services;

import java.util.List;

import com.cetpa.models.BookCategory;

public interface CategoryService 
{
	List<BookCategory> getList();
	void saveRecord(BookCategory cat);
	void deleteRecord(int cid);
	BookCategory getRecord(int cid);
}
