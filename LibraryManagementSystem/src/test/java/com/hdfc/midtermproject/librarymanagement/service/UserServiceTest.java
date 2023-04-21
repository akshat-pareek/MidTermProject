package com.hdfc.midtermproject.librarymanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hdfc.midtermproject.librarymanagement.dto.UserDTO;
import com.hdfc.midtermproject.librarymanagement.entity.User;

@SpringBootTest
class UserServiceTest {
	
	private static IUserService userService;
	
	@BeforeAll
	private static void setup() {
		userService=mock(IUserService.class);
	}
	
	@Test
	void registerUserTest() {
		UserDTO dto=new UserDTO();
		User user=new User();
		when(userService.registerUser(dto)).thenReturn(user);
		assertEquals(user, userService.registerUser(dto));
	}
	
	@Test
	void updateUserTest() {
		UserDTO dto=new UserDTO();
		User user=new User();
		when(userService.updateUser(dto)).thenReturn(user);
		assertEquals(user, userService.updateUser(dto));
	}
	
	@Test
	void deleteUserTest() {
		long userId=0L;
		userService.deleteUser(userId);
	}
	
	@Test
	void getAllUsersTest() {
		List<User> users=new ArrayList<>();
		when(userService.getAllUsers()).thenReturn(users);
		assertEquals(users, userService.getAllUsers());
	}
}
