package com.cetpa.services;

import java.util.List;

import com.cetpa.models.Book;

public interface SearchBookService 
{
	List<Book> getList(int bookid);
	List<Book> getListByAuthor(String author);
	List<Book> getListByTitle(String title);
	List<Book> getListByCatgory(int catid);
	List<Book> getListByPublisher(int pubid);
}
