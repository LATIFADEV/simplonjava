package com.manageractivity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.manageractivity.model.Users;
import com.manageractivity.repository.UserRepository;

@Service
public class UserServiceImp implements DAOService<Users>{
     @Autowired
	 private UserRepository repository; 

	@Override
	public Users find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users create(Users obj) {
		return repository.save(obj);
	}

	@Override
	public Users update(Users obj)   {
	
//		 // check if the user with the passed id exists or not
//	    Users userDB = repository.findById(obj.getId()).orElseThrow();
//	    // If user exists then updated
//	    repository.save(obj);
		return obj;
	}

	@Override
	public void delete(int id) {
		 try {
		      repository.deleteById(id);  
		    }catch(DataAccessException ex){
		      throw new RuntimeException(ex.getMessage());
		    }
	}

	@Override
	public Users getById(int id) {
		 return repository.findById(id).get();
	}

	@Override
	public List<Users> getAll() {
		 return repository.findAll();
	}

	
	
}
