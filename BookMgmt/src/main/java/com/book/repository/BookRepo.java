package com.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.book.model.Book;

@Repository
@EnableJpaRepositories
public interface BookRepo extends JpaRepository<Book,Integer>{

	Book findByBookName(String bookName);

	String deleteBybookId(int bookId);

	Book findByBookId(int bookId);

	List<Book> findByUser_Id(int user_id);

}