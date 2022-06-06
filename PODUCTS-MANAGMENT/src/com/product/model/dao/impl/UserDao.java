package com.product.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.product.domain.Product;
import com.product.domain.User;
import com.product.model.dao.DAO;

public class UserDao implements DAO<User>{
	
	
	@Override
	public User read(User obj) {
		
		return null;
	}

public  boolean LogIn(String firstname, String email) {
		
		try {
		    Statement stmt = connect.createStatement();
//		    ResultSet rs = stmt.executeQuery("SELECT * FROM userr WHERE firstname= '"+firstname +"'and email='"+email+"'");
		     String req= "SELECT * FROM userr WHERE firstname='"+firstname +"' and email='"+email+"'";	
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
	public User find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean update( int id ,User user) {
	
		 try {
			 String sql = "UPDATE userr SET firstname=?,lastname=?, email =?,adress=?,city=?,country=? WHERE id=? ";
		      PreparedStatement ps = connect.prepareStatement(sql);
				ps.setString(2,user.getLastname());
				ps.setString(3,user.getEmail());
				ps.setString(4,user.getAdresse());
				ps.setString(5,user.getCity());
				ps.setString(6,user.getCountry());
				ps.setInt(7, id);

		        int i = ps.executeUpdate();
		      if(i == 1) {
		  	    return true;
		      }
		      ps.close();
			    connect.close();

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		    return false;
	}

	@Override
	public boolean delete(int id) {
		 try {
		        Statement stmt = connect.createStatement();
		        int i = stmt.executeUpdate("DELETE FROM userr WHERE id=" + id);

		      if(i == 1) {
		        return true;
		      }
			    stmt.close();
			    connect.close();

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		    
		    
			return false;
		
	}

	@Override
	public ArrayList<Product> voirProduit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product ajouter(Product produit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierProduit(Product product, int IdProduitAModifier) {
		// TODO Auto-generated method stub
		
	}

	
	

}
