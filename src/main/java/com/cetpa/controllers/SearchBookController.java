package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.models.Book;
import com.cetpa.services.CategoryService;
import com.cetpa.services.PublisherService;
import com.cetpa.services.SearchBookService;

@Controller
@RequestMapping("bookstore/inventory/book/search")
public class SearchBookController 
{
	@Autowired private SearchBookService bservice;
	@Autowired private CategoryService cservice;
	@Autowired private PublisherService pservice;
	
	@RequestMapping("")
	public String getSearchBookOptionsView(Model model)
	{
		model.addAttribute("clist",cservice.getList());
		model.addAttribute("plist",pservice.getList());
		return "search/search-options";
	}
	@RequestMapping("byid")
	public String searchBookById(int bookid,Model model)
	{
		List<Book> list=bservice.getList(bookid);
		model.addAttribute("blist",list);
		model.addAttribute("by","bookid");
		return "search/book-list";
	}
	@RequestMapping("byauthor")
	public String searchBookByAuthor(String author,Model model)
	{
		List<Book> list=bservice.getListByAuthor(author);
		model.addAttribute("blist",list);
		model.addAttribute("by","author");
		return "search/book-list";
	}
	@RequestMapping("bytitle")
	public String searchBookByTitle(String title,Model model)
	{
		List<Book> list=bservice.getListByTitle(title);
		model.addAttribute("blist",list);
		model.addAttribute("by","title");
		return "search/book-list";
	}
	@RequestMapping("bycategory")
	public String searchBookByCategory(int catid,Model model)
	{
		List<Book> list=bservice.getListByCatgory(catid);
		model.addAttribute("blist",list);
		model.addAttribute("by","category");
		return "search/book-list";
	}
	@RequestMapping("bypublisher")
	public String searchBookByPublisher(int pubid,Model model)
	{
		List<Book> list=bservice.getListByPublisher(pubid);
		model.addAttribute("blist",list);
		model.addAttribute("by","publisher");
		return "search/book-list";
	}
}
