package com.todolist.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import com.todolist.domin.Task;
import com.todolist.domin.User;
import com.todolist.model.dao.DAO;

public class UserDAO implements DAO<User> {
	@Override
	public User create(User obj) {
		
		try {
		String sql ="INSERT INTO users (firstname,lastname,username,password) VALUES (?,?, ?, ?)";
		PreparedStatement ps= connect.prepareStatement(sql);

		connect.setAutoCommit(false);
		
		ps.setString(1, obj.getFirstname());
		ps.setString(2, obj.getLastname());
		ps.setString(3, obj.getUsername());
		ps.setString(4, obj.getPassword());
		ps.execute();
        connect.commit();
		ps.close();
		
		
		return obj;
		
	}catch ( SQLException e) {
		e.printStackTrace();
		
		return null;
	}

	    }

	@Override
	public boolean login(String username, String password) {
		try {
		    Statement stmt = connect.createStatement();
		     String req= "SELECT * FROM users WHERE username='"+username +"' and password='"+password+"'";	
		    ResultSet rs = stmt.executeQuery(req);
		    		    while ( rs.next() ) {
	              return true;
	          }
			
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}

	return false;
	}

	@Override
	public User update(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Task> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
