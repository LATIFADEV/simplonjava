package com.manageractivity.service;

import java.util.List;

import com.manageractivity.model.Users;

public interface UserService {
	  Users addUser(Users user);
	  Users getUserById(int userId);
	  void updateUser(Users user);
	  void deleteUserById(int userId);
	  List<Users> getAllUsers();
}
