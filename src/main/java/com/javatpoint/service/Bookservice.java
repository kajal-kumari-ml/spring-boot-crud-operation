package com.javatpoint.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.exception.BookNameNotFoundException;
import com.javatpoint.exception.BookNotFound;
import com.javatpoint.main.Books;
import com.javatpoint.repo.bookRepository;

@Service
public class Bookservice {
	@Autowired
	bookRepository repository;

	public List<Books> getBookbyName(String bookname){
		// TODO Auto-generated method stub
		List<Books> books=new ArrayList<Books>();
		repository.findBybookname(bookname).forEach(book1->books.add(book1));
		if(books.size()==0)
			throw new BookNameNotFoundException("bookname not found"+bookname);
		return books;
		
	}

	public List<Books> getAllBooks() {
		List<Books> books=new ArrayList<Books>();
		repository.findAll().forEach(book1->books.add(book1)); 
		return books;
	}

	public Books getBookbyid(int id) {
		// TODO Auto-generated method stub
		Optional<Books> findByid= Optional.of(repository.findById(id).get());
		if(findByid.isPresent())
		{
			return findByid.get();
		}
		throw new BookNotFound("bookid is not available"+id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);;
	}

	public Books saveOrupdate(Books books) {
		// TODO Auto-generated method stub
		return repository.save(books);
		
	}

}
