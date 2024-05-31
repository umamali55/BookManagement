package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.book.model.User;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User,Integer>{

	User findByEmail(String email);

}