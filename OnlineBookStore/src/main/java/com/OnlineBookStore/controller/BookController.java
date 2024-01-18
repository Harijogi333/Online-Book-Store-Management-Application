package com.OnlineBookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.OnlineBookStore.entity.Book;
import com.OnlineBookStore.entity.MyBooksList;
import com.OnlineBookStore.service.BookService;
import com.OnlineBookStore.service.MyBooksListService;


@Controller
public class BookController 
{
	@Autowired
	private BookService bService;
	
	@Autowired
	private MyBooksListService mService;
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	@GetMapping("/book_register")
	public String bookRegister()
	{
		return "bookRegister";
	}
	@GetMapping("/available_books")
	public ModelAndView getBooks()
	{
		List<Book> list=bService.getAllBooks();
		ModelAndView m=new ModelAndView();
		m.setViewName("bookList");
		m.addObject("book",list);
		return new ModelAndView("bookList","book",list);
	}
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b)
	{
		bService.save(b);
		return "redirect:/available_books";
	}
	@GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
		List<MyBooksList> list=mService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id)
	{
		Book b=bService.getBookById(id);
		MyBooksList mb=new MyBooksList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		mService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	@RequestMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") int id,Model model)
	{
		Book b=bService.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	@RequestMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable("id") int id)
	{
		bService.deleteById(id);
		return "redirect:/available_books";
	}
	
}
