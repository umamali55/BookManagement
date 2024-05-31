package com.book.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.book.dto.BookDto;
import com.book.model.Book;
import com.book.service.BookService;

@RestController
@RequestMapping("/adminbook")
public class AdminBookController {
	
	@Autowired 
	private BookService bookService;
	
	
	@PostMapping("/add")
	public String addBook(@RequestParam("bookId")int bookId,
						  @RequestParam("bookName")String bookName,
						  @RequestParam("bookAuthor")String bookAuthor,
						  @RequestParam("bookPrice")float bookPrice,
						  @RequestParam("description")String description,
						  @RequestParam("bookImage")MultipartFile bookImage)throws IOException{
		byte[] bookImageBytes = bookImage.getBytes();
		BookDto bookDto=new BookDto();
		bookDto.setBookId(bookId);
		bookDto.setBookName(bookName);
		bookDto.setBookAuthor(bookAuthor);
		bookDto.setBookPrice(bookPrice);
		bookDto.setDescription(description);
		bookDto.setBookImage(bookImageBytes);
		return bookService.newBook(bookDto);
	}
	
	@GetMapping("/getall")
	public List<Book>getallBooks(){
		return bookService.fetchAllBooks();
	}
	
	@GetMapping("/getByName/{bookName}")
	public Book getByName(@PathVariable String bookName) {
		return bookService.fetchByName(bookName);
	}
	
	@DeleteMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable int bookId) {
		return bookService.removebook(bookId);
	}
	
	@GetMapping("/getbyId/{bookId}")
	public Book getById(@PathVariable int bookId) {
		return bookService.fetchById(bookId);
	}
	
	@PutMapping("/update/{bookId}")
	public String editBook(@PathVariable int bookId,
			 @RequestParam("bookName")String bookName,
			  @RequestParam("bookAuthor")String bookAuthor,
			  @RequestParam("bookPrice")float bookPrice,
			  @RequestParam("description")String description,
			  @RequestParam("bookImage")MultipartFile bookImage)throws IOException{
		byte[] bookImageBytes=bookImage.getBytes();
		Book book = new Book();
		book.setBookName(bookName);
		book.setBookAuthor(bookAuthor);
		book.setBookPrice(bookPrice);
		book.setDescription(description);
		book.setBookImage(bookImageBytes);
		boolean updated=bookService.updateBook(bookId,book);
		if(updated) {
			return "Book Updated";
		}
		else {
			return "Not Updated";
		}
	}
	
}