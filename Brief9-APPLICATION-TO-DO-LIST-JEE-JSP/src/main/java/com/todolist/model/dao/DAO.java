package com.todolist.model.dao;

import java.sql.Connection;
import java.text.ParseException;
import java.util.Set;

import com.todolist.domin.Task;
import com.todolist.model.db.DB;

public interface DAO<T> {

	 public Connection connect = DB.getInstance();
	 public  T create(T obj) throws ParseException;
	 public abstract boolean login (String username,String password);
	 public abstract T update(long id);
	 
	Set<Task> getAll();
	 public boolean delete(int id);
	    
	   
}
