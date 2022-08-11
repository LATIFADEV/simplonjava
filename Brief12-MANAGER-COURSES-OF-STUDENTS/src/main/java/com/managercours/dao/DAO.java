package com.managercours.dao;

import java.util.List;

import com.managercours.entities.User;


public interface DAO<T> {
public void persist(T entity);
	
	public void update(T entity);
	
	public T findById(int id);
	
	public void delete(int id);
	
	public List<T> findAll();

}
