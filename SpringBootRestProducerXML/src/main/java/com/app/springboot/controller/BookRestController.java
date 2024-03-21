package com.app.springboot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springboot.bean.Book;

@RestController
@RequestMapping("/book")
public class BookRestController {
	
	@PostMapping("/save")
	public ResponseEntity<String> createBook(@RequestBody Book book){
		System.out.println(book);
		return new ResponseEntity<String>("Data Received", HttpStatus.OK);
	}
	
	@GetMapping("/find")
	public ResponseEntity<Book> fetchOneBook(){
		return new ResponseEntity<Book>(new Book(101,"Core Java",300.00),HttpStatus.OK);
	}
	
	@GetMapping("/find/{bookId}")
	public ResponseEntity<Book> fetchOneBook(@PathVariable Integer bookId){
		return new ResponseEntity<Book> (new Book(bookId,"AAA",200.00),HttpStatus.OK);
	} 
}
