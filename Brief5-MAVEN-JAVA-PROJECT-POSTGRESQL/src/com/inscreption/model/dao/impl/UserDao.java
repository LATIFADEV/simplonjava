package com.inscreption.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.inscreption.domain.User;
import com.inscreption.model.DB.DB;
import com.inscreption.model.dao.DAO;


public class UserDao extends DAO<User> {

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
//	      try {
//	           
//	            ResultSet result = this    .connect
//	                                    .createStatement(
//	                                            ResultSet.TYPE_SCROLL_INSENSITIVE, 
//	                                            ResultSet.CONCUR_UPDATABLE
//	                                    ).executeQuery(
//	                                            "SELECT NEXTVAL('developpeur_dev_id_seq') as id"
//	                                    );
//	            if(result.first()){
//	                long id = result.getLong("id");
//	                PreparedStatement prepare = this    .connect
//	                                                    .prepareStatement(
//	                                                        "INSERT INTO userr (id, firstname, lastname,email,adress,city,country)"+
//	                                                        "VALUES(?, ?, ?, ?,?,?,?)"
//	                                                    );
//	                prepare.setLong(1, id);
//	                prepare.setString(2, obj.getFirstname());
//	                prepare.setString(3, obj.getLastname());
//	                prepare.setString(4, obj.getEmail());
//	                prepare.setString(5, obj.getAdresse());
//	                prepare.setString(6, obj.getCity());
//	                prepare.setString(7, obj.getCountry());
//	                
//	                prepare.executeUpdate();
//	                obj = this.find(id);    
//	                
//	            }
//	        } catch (SQLException e) {
//	                e.printStackTrace();
//	        }
//	        return obj;
	    }
	

	@Override
	public User update(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User obj) {
		// TODO Auto-generated method stub
		
	}
	
	

}
