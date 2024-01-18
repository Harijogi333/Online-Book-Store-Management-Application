package com.OnlineBookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineBookStore.entity.MyBooksList;
import com.OnlineBookStore.repository.MyBooksListRepository;

@Service
public class MyBooksListService
{

	@Autowired
	private MyBooksListRepository repo;
	
	public void saveMyBooks(MyBooksList book)
	{
		repo.save(book);
	}
	
	public List<MyBooksList> getAllMyBooks()
	{
		return repo.findAll();
	}
	
	public void DeleteById(int id)
	{
		repo.deleteById(id);
	}
}
