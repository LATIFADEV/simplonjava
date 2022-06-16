package com.inscreption.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.inscreption.domain.User;
import com.inscreption.model.dao.DAO;
import com.inscreption.model.db.DB;

public class UserDAO implements DAO<User>{

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
		
		
		return obj;
		
	}catch ( SQLException e) {
		e.printStackTrace();
		
		return null;
	}

	    }
	

	@Override
	public boolean update(int id,User obj) {
	      System.out.println("Mise à jour...");

		
		 try {
			   
		        PreparedStatement stmt = connect.prepareStatement("UPDATE userr SET firstname=?,lastname=?, email=?,adress=?,city=?,country=? WHERE id= ?");
			      stmt.setString(1,obj.getFirstname());
			      stmt.setString(2,obj.getLastname());
			      stmt.setString(3,obj.getEmail());
			      stmt.setString(4,obj.getAdresse());
			      stmt.setString(5,obj.getCity());
			      stmt.setString(6,obj.getCountry());
			      stmt.setInt(7, id);
			      int i = stmt.executeUpdate();

			      
			       if(i==1) {
					      System.out.println("Mise à jour...");
	                    return true;
			       }
	               
			    stmt.close();

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		    return false;
	        
	}

	@Override
	public boolean delete(int id) {

		String sql= "DELETE FROM userr WHERE id= ?";
		try {
			PreparedStatement pst = connect.prepareStatement(sql);
//			connect.setAutoCommit(false);
			pst.setInt(1, id);
			pst.executeUpdate();
//	        connect.commit();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return false;		
		
	}
	
	@Override
	public User find(long id)   {
				   
		try {
		    Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM userr WHERE id=" + id);

		    while ( rs.next() ) {
				   User user = getUserFromResultSet(rs);
				   return user;
	          }

		} catch (SQLException ex) {
		    ex.printStackTrace();
		}

		return null;

}
		
	private static User getUserFromResultSet(ResultSet rs) throws SQLException
    {
            User user = new User();
            user.setIdUser(rs.getInt("id"));
		   	user.setFirstname( rs.getString("firstname"));
		    user.setLastname( rs.getString("lastname"));
			user.setEmail( rs.getString("email"));
			user.setAdresse( rs.getString("adress"));
		    user.setCity(rs.getString("city"));
			user.setCountry( rs.getString("country"));
        return user;
    }
	
	@Override
	public Set<User> getAll() {

		    try {
		        Statement stmt = connect.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT * FROM  userr");
		        Set<User> users = new HashSet<User>();
		        
		   	 while ( rs.next() ) {
//		 		connect.setAutoCommit(false);

			   	User user = new User();
			   	user.setIdUser(rs.getInt("id"));
			   	user.setFirstname( rs.getString("firstname"));
			    user.setLastname( rs.getString("lastname"));
				user.setEmail( rs.getString("email"));
				user.setAdresse( rs.getString("adress"));
			    user.setCity(rs.getString("city"));
				user.setCountry( rs.getString("country"));
			    users.add(user);
		        }
//		        connect.commit();
				stmt.close();
		        return users;

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		    return null;
	}
	
	


}
