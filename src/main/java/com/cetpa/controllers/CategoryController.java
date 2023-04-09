package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.models.BookCategory;
import com.cetpa.services.BookService;
import com.cetpa.services.CategoryService;

@Controller
@RequestMapping("bookstore/inventory/category")
public class CategoryController 
{
	@Autowired private CategoryService service;
	
	@RequestMapping("dashboard")
	public String getDashboardView(Model model)
	{
		List<BookCategory> list=service.getList();
		model.addAttribute("clist",list);
		return "category/category-list";
	}
	@RequestMapping("add")
	public String getAddCategoryView()
	{
		return "category/add-category";
	}
	@RequestMapping("save")
	public String saveCategory(BookCategory cat)
	{
		service.saveRecord(cat);
		return "redirect:dashboard";
	}
	@RequestMapping("remove")
	public String removeCategory(int cid)
	{
		service.deleteRecord(cid);
		return "redirect:dashboard";
	}
	@RequestMapping("edit")
	public String getEditCategoryView(Model model,int cid)
	{
		BookCategory cat=service.getRecord(cid);
		model.addAttribute("cat",cat);
		return "category/edit-category";
	}
	@RequestMapping("update")
	public String updateCategory(BookCategory cat)
	{
		service.saveRecord(cat);
		return "redirect:dashboard";
	}
}
