package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.dto.LoginDto;
import com.book.service.UserService;

@RestController
@RequestMapping("/adminuser")
public class AdminUserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/allusers")
	public List<User>getall(){
		return userService.fetchAll();
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.removeUser(id);
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody LoginDto loginDto) {
		return userService.userLogin(loginDto);
	}
}