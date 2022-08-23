package com.manageractivity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.manageractivity.model.Users;
import com.manageractivity.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	  @Autowired
	  private UserRepository repository;
	  @Override
	  public Users addUser(Users user) {
	    return repository.save(user);
	  }
	  @Override
	  public Users getUserById(int userId) {
	    return repository.findById(userId).get();
	  }
	  @Override
	  public List<Users> getAllUsers(){
	    return repository.findAll();
	  }
	  
//	  @Override
//	  public void updateUser(Users user) {
//	    // check if the user with the passed id exists or not
//	    Users userDB = repository.findById(user.getId()).orElseThrow();
//	    // If user exists then updated
//	    repository.save(user);
//	  }
	  
	  @Override
	  public void deleteUserById(int userId) {
	    try {
	      repository.deleteById(userId);  
	    }catch(DataAccessException ex){
	      throw new RuntimeException(ex.getMessage());
	    }
	  }
	@Override
	public void updateUser(Users user) {
	
		
	}

}
