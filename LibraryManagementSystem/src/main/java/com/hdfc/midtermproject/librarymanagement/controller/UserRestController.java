package com.hdfc.midtermproject.librarymanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.midtermproject.librarymanagement.dto.UserDTO;
import com.hdfc.midtermproject.librarymanagement.entity.User;
import com.hdfc.midtermproject.librarymanagement.exception.NotFoundException;
import com.hdfc.midtermproject.librarymanagement.service.IUserService;

@RestController
@RequestMapping("/library/user")
public class UserRestController {
	
	@Autowired
	private IUserService service;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody UserDTO dto) {
		User user= service.registerUser(dto);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@Valid @RequestBody UserDTO dto) {
		User user= service.updateUser(dto);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable long userId) {
		service.deleteUser(userId);
		return  new ResponseEntity<String>("Record Deleted ",HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public List<User> getAllUsers() throws Exception{
		if(service.getAllUsers().isEmpty()) {
			throw new NotFoundException("No users found");
		}
		return service.getAllUsers();
	}
}
