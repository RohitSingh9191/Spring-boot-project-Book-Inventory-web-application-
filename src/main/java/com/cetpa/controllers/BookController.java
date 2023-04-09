package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.models.Book;
import com.cetpa.models.BookCategory;
import com.cetpa.services.BookService;
import com.cetpa.services.CategoryService;
import com.cetpa.services.PublisherService;

@Controller
@RequestMapping("bookstore/inventory/book")
public class BookController 
{
	@Autowired private BookService bservice;
	@Autowired private CategoryService cservice;
	@Autowired private PublisherService pservice;
	
	@RequestMapping("dashboard")
	public String getDashboardView(Model model)
	{
		List<Book> list=bservice.getList();
		model.addAttribute("blist",list);
		return "book/book-list";
	}
	@RequestMapping("add")
	public String getAddBookView(Model model)
	{
		model.addAttribute("clist",cservice.getList());
		model.addAttribute("plist",pservice.getList());
		return "book/add-book";
	}
	@RequestMapping("save")
	public String saveBook(Book book)
	{
		bservice.saveRecord(book);
		return "redirect:dashboard";
	}
	@RequestMapping("remove")
	public String removeBook(int bid)
	{
		bservice.deleteRecord(bid);
		return "redirect:dashboard";
	}
	@RequestMapping("edit")
	public String getEditBookView(Model model,int bid)
	{
		Book book=bservice.getRecord(bid);
		model.addAttribute("book",book);
		model.addAttribute("clist",cservice.getList());
		model.addAttribute("plist",pservice.getList());
		return "book/edit-book";
	}
	@RequestMapping("update")
	public String updateBook(Book book)
	{
		bservice.saveRecord(book);
		return "redirect:dashboard";
	}
}
