package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.book.dto.BookDto;
import com.book.model.Book;
import com.book.repository.BookRepo;
import com.book.repository.UserRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private UserRepo userRepo;

	
	public String newBook(BookDto bookDto) {
		Book book =new Book(bookDto.getBookId(),
							bookDto.getBookName(),
							bookDto.getBookAuthor(),
							bookDto.getBookPrice(),
							bookDto.getDescription(),
							bookDto.getBookImage());
		bookRepo.save(book);
		return "Book Added";
	}

	@Override
	public List<Book> fetchAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public Book fetchByName(String bookName) {
		return bookRepo.findByBookName(bookName);
	}

	@Override
	public String removebook(int bookId) {
		 bookRepo.deleteBybookId(bookId);
		 return "Deleted successfully";
	}

	@Override
	public Book fetchById(int bookId) {
		return bookRepo.findByBookId(bookId);
	}

	@Override
	public boolean updateBook(int bookId, Book book) {
		Book existingBook=bookRepo.findByBookId(bookId);
		if(existingBook!=null) {
			existingBook.setBookName(book.getBookName());
			existingBook.setBookAuthor(book.getBookAuthor());
			existingBook.setBookPrice(book.getBookPrice());
			existingBook.setDescription(book.getDescription());
			existingBook.setBookImage(book.getBookImage());
			bookRepo.save(existingBook);
			return true;
		}
		return false;
	}

	@Override
	public String getBook(int bookId, int user_id) {
		Book book=bookRepo.findByBookId(bookId);
		System.out.println(book);
		User user=userRepo.findById(user_id).orElseThrow();
		if(book!=null&&user!=null) {
			book.setUser(user);
			return "Success";
		}
		else {
			return "failed";
		}
		
	}

	@Override
	public List<Book> getByUserId(int user_id) {
		return bookRepo.findByUser_Id(user_id);
	}
	
}