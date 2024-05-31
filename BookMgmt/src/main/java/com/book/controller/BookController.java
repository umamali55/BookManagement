package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.dto.BuyBook;
import com.book.model.Book;
import com.book.service.BookService;

@RestController
@RequestMapping("/userbook")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/getall")
	public List<Book>getallBooks(){
		return bookService.fetchAllBooks();
	}
	
	@GetMapping("/findByName/{bookName}")
	public Book getByName(@PathVariable String bookName) {
		return bookService.fetchByName(bookName);
	}
	
	@PostMapping("/buybook")
	public String buyBook(@RequestBody BuyBook buyBook) {
		int bookId = buyBook.getBookId();
        int user_id = buyBook.getUserId();
        System.out.println(bookId+" "+user_id);
		return bookService.getBook(bookId,user_id);
	}
	
	@GetMapping("/getByuserid/{user_id}")
	public List<Book>getById(@PathVariable int user_id){
		return bookService.getByUserId(user_id);
	}
	
}