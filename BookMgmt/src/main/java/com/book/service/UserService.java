package com.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.book.dto.LoginDto;
import com.book.dto.UserDto;
import com.book.model.User;

@Service
public interface UserService {

	String newUser(UserDto userDto);

	List<User> fetchAll();

	String removeUser(int id);

	boolean editUser(int id, UserDto userDto);

	User userLogin(LoginDto loginDto);

	User getById(int id);

}