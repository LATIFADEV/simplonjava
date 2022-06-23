package com.todolist.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import com.todolist.domin.Categorie;
import com.todolist.domin.Task;
import com.todolist.model.dao.DAO;

public class CategorieDAO implements DAO<Categorie> {

	@Override
	public Categorie create(Categorie obj) {
		 try {
		        PreparedStatement stmt = connect.prepareStatement("INSERT INTO categorie name VALUES (?)");
		        stmt.setString(1, obj.getName_categorie());
		        int i = stmt.executeUpdate();

		      if(i == 1) {
		         System.out.println("bien");
		      }
			    stmt.close();
			    connect.close();

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		   System.out.println("pas creer");
		return obj;
		}

	


	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Categorie update(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Categorie delete() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Set<Task> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
