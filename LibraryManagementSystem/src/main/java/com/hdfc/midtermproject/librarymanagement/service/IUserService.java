package com.hdfc.midtermproject.librarymanagement.service;

import java.util.List;

import com.hdfc.midtermproject.librarymanagement.dto.UserDTO;
import com.hdfc.midtermproject.librarymanagement.entity.User;

public interface IUserService {
	
	public User registerUser(UserDTO dto);
	
	public User updateUser(UserDTO dto);
	
	public void deleteUser(long userId);
	
	public List<User> getAllUsers();
}