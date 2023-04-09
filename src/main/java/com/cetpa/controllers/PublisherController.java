package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.models.BookCategory;
import com.cetpa.models.BookPublisher;
import com.cetpa.services.PublisherService;

@Controller
@RequestMapping("bookstore/inventory/publisher")
public class PublisherController 
{
	@Autowired private PublisherService service;
	
	@RequestMapping("dashboard")
	public String getDashboardView(Model model)
	{
		List<BookPublisher> list=service.getList();
		model.addAttribute("plist",list);
		return "publisher/publisher-list";
	}
	@RequestMapping("add")
	public String getAddPublisherView()
	{
		return "publisher/add-publisher";
	}
	@RequestMapping("save")
	public String savePublisher(BookPublisher pub)
	{
		service.saveRecord(pub);
		return "redirect:dashboard";
	}
	@RequestMapping("remove")
	public String removePublisher(int pid)
	{
		service.deleteRecord(pid);
		return "redirect:dashboard";
	}
	@RequestMapping("edit")
	public String getEditPublisherView(Model model,int pid)
	{
		BookPublisher pub=service.getRecord(pid);
		model.addAttribute("pub",pub);
		return "publisher/edit-publisher";
	}
	@RequestMapping("update")
	public String updatePublisher(BookPublisher cat)
	{
		service.saveRecord(cat);
		return "redirect:dashboard";
	}
}
