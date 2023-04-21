package com.hdfc.midtermproject.librarymanagement.service;

/*  Implementation of IUserService interface named UserServiceImp.
	It uses an instance of UserRepository which extends to JPA repository 
	to perform CRUD operations.
	
	registerUser method takes a UserDTO object as input, creates a new 
	User object using its properties, and saves it using the userRepository.

	updateUser method does the same thing as registerUser by overwriting the
	previous data with the new data.

	deleteUser method takes a userId parameter, used to delete a User entity 
	with that ID using the userRepository.

	getAllUsers method returns a list of all User entities using the 
	userRepository's findAll method.
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.midtermproject.librarymanagement.dto.UserDTO;
import com.hdfc.midtermproject.librarymanagement.entity.User;
import com.hdfc.midtermproject.librarymanagement.repository.UserRepository;

@Service
public class UserServiceImp implements IUserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(UserDTO dto) {
		User user=new User();
		user.setUserId(dto.getUserId());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setAccountStatus(dto.getAccountStatus());
		return userRepository.save(user);
	}

	@Override
	public User updateUser(UserDTO dto) {
		User user=new User();
		user.setUserId(dto.getUserId());
		user.setFirstName(dto.getFirstName());
		user.setEmail(dto.getEmail());
		user.setLastName(dto.getLastName());
		user.setPassword(dto.getPassword());
		user.setAccountStatus(dto.getAccountStatus());
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(long userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
