package com.manageractivity.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.manageractivity.model.Users;
import com.manageractivity.repository.UserRepository;
import com.manageractivity.service.UserServiceImp;

@RestController
@RequestMapping("/users")
public class UserController {


	  @Autowired
	  UserServiceImp userService;
	  // Insert user record
	  @PostMapping
	  @ResponseStatus(HttpStatus.CREATED)
	  public Users addEmployee(@RequestBody Users user) {
	    return userService.addUser(user);
	  }
	  // Fetch all user records
	  @GetMapping
	  public List<Users> getAllUsers(){
	    return userService.getAllUsers();
	  }
	  // Fetch single user
	  @GetMapping("/{id}")
	  public Users getUserById(@PathVariable("id") int userId){
	    return userService.getUserById(userId);
	  }
	  // Update user record
	  @PutMapping("/updateuser")
	  public ResponseEntity<String> updateUser(@RequestBody Users user) {  
	    try {
	      userService.updateUser(user);
	      return new ResponseEntity<String>(HttpStatus.OK);
	    }catch(NoSuchElementException ex){
	      // log the error message
	      System.out.println(ex.getMessage());
	      return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	    }
	  }
	  // Delete user record
	  @DeleteMapping("/{id}")
	  public ResponseEntity<String> deleteUser(@PathVariable int id){
	    try {
	      userService.deleteUserById(id);
	      return new ResponseEntity<String>(HttpStatus.OK);
	    }catch(RuntimeException ex){
	      // log the error message
	      System.out.println(ex.getMessage());
	      return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	    }
	  }

}
