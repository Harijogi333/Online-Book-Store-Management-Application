package com.OnlineBookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.OnlineBookStore.service.MyBooksListService;

@Controller
public class MyBooksListController
{
	@Autowired
	private MyBooksListService mService;

	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id)
	{
		mService.DeleteById(id);
		return "redirect:/my_books";
	}
}
