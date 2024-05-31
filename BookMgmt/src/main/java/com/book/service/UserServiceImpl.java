package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.book.dto.LoginDto;
import com.book.dto.UserDto;
import com.book.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired 
	private UserRepo userRepo;

	@Override
	public String newUser(UserDto userDto) {
		User user =new User(userDto.getId(),
							userDto.getName(),
							userDto.getEmail(),
							userDto.getContact(),
							userDto.getRole(),
							userDto.getPassword());
		userRepo.save(user);
		return "Added Succesfully";
	}

	@Override
	public List<User> fetchAll() {
		return userRepo.findAll();
	}

	@Override
	public String removeUser(int id) {
		userRepo.deleteById(id);
		return "Deleted Successfully";
	}

	@Override
	public boolean editUser(int id, UserDto userDto) {
		User existingUser = userRepo.findById(id).orElseThrow();
		if(existingUser!=null) {
			existingUser.setName(userDto.getName());
			existingUser.setEmail(userDto.getEmail());
			existingUser.setContact(userDto.getContact());
			userRepo.save(existingUser);
			return true;
		}
		return false;
	}

	@Override
	public User userLogin(LoginDto loginDto) {
		User user=userRepo.findByEmail(loginDto.getEmail());
		if(user!=null) {
			String pass1=loginDto.getPassword();
			String pass2=user.getPassword();
			String role1=loginDto.getRole();
			String role2=user.getRole();
			System.out.println("chk pass");
			if(pass1.equals(pass2)&&role1.equals(role2)) {
				System.out.println("in cnd");
				return user;
			}
			else {
				System.out.println("inner");
				return null;
			}
		}
		System.out.println("outer");
		return null;
	}

	@Override
	public User getById(int id) {
		return userRepo.findById(id).orElseThrow();
	}
	
	
}
