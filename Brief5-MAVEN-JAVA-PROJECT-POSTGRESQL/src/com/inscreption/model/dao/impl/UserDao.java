package com.inscreption.model.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.inscreption.domain.User;
import com.inscreption.model.DB.DB;
import com.inscreption.model.dao.DAO;


public class UserDao implements DAO<User> {

	@Override
	public User find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User create(User obj) {
	
		
		
		try {
		String sql ="INSERT INTO userr (firstname,lastname,email,adress,city,country) VALUES (?,?, ?, ?, ?,?)";
		PreparedStatement ps= connect.prepareStatement(sql);

		connect.setAutoCommit(false);
		
		ps.setString(1, obj.getFirstname());
		ps.setString(2, obj.getLastname());
		ps.setString(3, obj.getEmail());
		ps.setString(4, obj.getAdresse());
		ps.setString(5, obj.getCity());
		ps.setString(6, obj.getCountry());
		ps.execute();
		
        connect.commit();
		ps.close();
		connect.close();
		
		return obj;
		
	}catch ( SQLException e) {
		//e.printStackTrace();
		System.out.println(e.getMessage());
		return null;
	}

	    }
	

	@Override
	public User update(User obj) {
		 try{    
		      String sql = "UPDATE userr SET firstname=?,lastname=?, email =?,adress=?,city=?,country=? WHERE id=? ";
		      PreparedStatement stmt = connect.prepareStatement(sql);
		      stmt.setString(1,obj.getFirstname());
		      stmt.setString(2,obj.getLastname());
		      stmt.setString(3,obj.getEmail());
		      stmt.setString(4,obj.getAdresse());
		      stmt.setString(5,obj.getCity());
		      stmt.setString(6,obj.getCountry());
		      stmt.setInt(7, 4);
		      System.out.println("Mise à jour...");
		      stmt.execute();   
		      connect.close();
		      
		      obj = this.find(obj.getIdUser());
		      
		      
	            
	        } catch (SQLException e) {
	                e.printStackTrace();
	        }
		 return obj;
	        
	}

	@Override
	public void delete(User obj) {
		try {
		            
		            this.connect    
		                .createStatement(
		                    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		                    ResultSet.CONCUR_UPDATABLE
		                 ).executeUpdate(
		                    "DELETE FROM userr WHERE id = " + obj.getIdUser()
		                 );
		
		        } catch (SQLException e) {
		                e.printStackTrace();
		        }
		    }
		
	
	
	

}
