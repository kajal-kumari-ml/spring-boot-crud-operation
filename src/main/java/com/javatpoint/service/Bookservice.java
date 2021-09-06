package com.javatpoint.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatpoint.exception.BookNameNotFoundException;
import com.javatpoint.exception.BookNotFound;
import com.javatpoint.main.Books;
import com.javatpoint.repo.BookRepository;

@Service
public class BookService
{
	Logger logger=LoggerFactory.getLogger(BookService.class);
	@Autowired
	BookRepository repository;
    
	public List<Books> getBookByName(String bookname)
	{
		List<Books> books=new ArrayList<Books>();
		repository.findBybookname(bookname).forEach(book1->books.add(book1));
		if(books.size()==0)
		{
			logger.info("book is not available "+bookname +" Explanation: you are search for "+bookname+"but book is not present in Database ");
			throw new BookNameNotFoundException("bookname not found"+bookname);
		}
		return books;	
	}

	public List<Books> getAllBooks()
	{
		List<Books> books=new ArrayList<Books>();
		repository.findAll().forEach(book1->books.add(book1)); 
		return books;
	}

	public Books getBookbyid(int id)
	{
		Optional<Books> findByid= repository.findById(id);
		if(findByid.isPresent())
		{
			return findByid.get();
		}
		logger.info("id is not available "+id +" Explanation: you are search for "+id+"but id is not present in Database ");
		throw new BookNotFound("bookid is not available"+id);
	}

	public void delete(int id) 
	{
	   repository.deleteById(id);
	}

	public Books saveOrupdate(Books books) 
	{
		return repository.save(books);	
	}

}
