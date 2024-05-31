package com.book.service;

import java.util.List;

import com.book.dto.BookDto;
import com.book.model.Book;

public interface BookService {

	String newBook(BookDto bookDto);

	List<Book> fetchAllBooks();

	Book fetchByName(String bookName);

	String removebook(int bookId);

	Book fetchById(int bookId);

	boolean updateBook(int bookId, Book book);

	String getBook(int bookId, int user_id);

	List<Book> getByUserId(int user_id);

}