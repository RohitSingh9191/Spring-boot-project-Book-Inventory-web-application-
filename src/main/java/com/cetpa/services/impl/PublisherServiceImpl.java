package com.cetpa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.BookPublisher;
import com.cetpa.repositories.PublisherRepository;
import com.cetpa.services.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService 
{
	@Autowired private PublisherRepository repo;

	public List<BookPublisher> getList() 
	{
		return repo.findAll();
	}
	public void saveRecord(BookPublisher pub) 
	{
		repo.save(pub);
	}
	public void deleteRecord(int pid) 
	{
		repo.deleteById(pid);
	}
	public BookPublisher getRecord(int pid) 
	{
		return repo.findById(pid).orElse(null);
	}
}
