package com.cetpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookstore/inventory")
public class HomeController 
{
	@RequestMapping("")
	public String getLoginView()
	{
		return "home/login.html";
	}
	@RequestMapping("authenticate")
	public String getLoginView(String username,String password,Model model)
	{
		if(username.equals("admin") && password.equals("admin"))
		{
			return "redirect:home";
		}
		model.addAttribute("user",username);
		model.addAttribute("msg","Username or password is incorrect");
		return "home/login.html";
	}
	@RequestMapping("home")
	public String getHomeView()
	{
		return "home/home-page.html";
	}
}
