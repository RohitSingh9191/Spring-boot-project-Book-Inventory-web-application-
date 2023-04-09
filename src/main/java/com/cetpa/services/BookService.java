package com.cetpa.services;

import java.util.List;

import com.cetpa.models.Book;

public interface BookService 
{
	List<Book> getList();
	void saveRecord(Book book);
	void deleteRecord(int bid);
	Book getRecord(int bid);
}
