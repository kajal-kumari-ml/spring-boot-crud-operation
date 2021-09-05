package com.javatpoint.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.main.Books;
import com.javatpoint.service.Bookservice;

import java.util.List;

@RestController
public class booksController {
	Logger logger=LoggerFactory.getLogger(booksController.class);
	
	@Autowired 
	Bookservice bookservice;
	 
	@GetMapping("/Books")
	public List<Books> getAllBooks()
	{
		return bookservice.getAllBooks();
	}
	@GetMapping("/Books/search")
	public List<Books> getnamebyId(@RequestParam String bookname)
	{
		logger.info("search for book "+bookname);
		return bookservice.getBookbyName(bookname);
	}
	
	@GetMapping("/Books/{bookid}")
	public Books getBook(@PathVariable int bookid)
	{
		logger.info("logging into the get book by id"+ bookid);
		return bookservice.getBookbyid(bookid);
	}
	
	@DeleteMapping("/Books/{bookid}")
	public void DeletebyId(@PathVariable int bookid)
	{
		logger.warn("Delete the book info "+bookid);
		bookservice.delete(bookid);
	}
	
	@PostMapping("/Books")
	public int saveBook(@RequestBody Books books)
	{
		bookservice.saveOrupdate(books);
		return books.getBookid();
	}
	
	@PutMapping("/Books")
	public Books update(@RequestBody Books books)
	{
		logger.trace("update the books info");
		bookservice.saveOrupdate(books);
		return books;
		
	}

}
