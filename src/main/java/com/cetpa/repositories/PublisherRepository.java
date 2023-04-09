package com.cetpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetpa.models.BookPublisher;

public interface PublisherRepository extends JpaRepository<BookPublisher,Integer> 
{
}
