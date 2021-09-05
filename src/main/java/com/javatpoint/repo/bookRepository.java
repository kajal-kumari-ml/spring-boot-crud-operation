package com.javatpoint.repo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javatpoint.main.Books;

public interface bookRepository extends CrudRepository<Books,Integer> {
   
	public List<Books> findBybookname(String bookname);

}
