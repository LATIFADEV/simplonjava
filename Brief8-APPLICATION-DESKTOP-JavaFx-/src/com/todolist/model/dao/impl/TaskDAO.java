package com.todolist.model.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JTextField;


import com.todolist.domin.Task;
import com.todolist.model.dao.DAO;

public class TaskDAO implements DAO<Task> {
	 
//	java.util.Date datedebut,datefin;
//	java.sql.Date Mydatedebut,Mydatefin;
	
    @Override
	public Task create(Task obj) throws ParseException {
    	
//    	SimpleDateFormat format = new SimpleDateFormat( "MM/dd/yyyy" );  // United States style of format.
//    	java.util.Date Dedline = format.parse( "10/10/2009" );  // Notice the ".util." of package name.

		try {
			

		String sql ="INSERT INTO task (title,discription,statut,Dedline) VALUES (?,?, ?, ?)";
		PreparedStatement ps= connect.prepareStatement(sql);
		connect.setAutoCommit(false);
		ps.setString(1, obj.getTitle());
		ps.setString(2, obj.getDiscription());
		ps.setString(3, obj.getStatut().name());
		ps.setDate(4, java.sql.Date.valueOf(obj.getDedline()));
//		ps.setString(4, obj.getDedline().toString());
//		ps.setDate( 5, date );
//		pst.setdate(5, dpcurrentdate.getvalue());  
//		ps.setDate(4,java.sql.Date.valueOf(obj.getDedline().toString()));
//		java.sql.Date sqlDate = new java.sql.Date( Dedline.getTime() ); // Notice the ".sql." (not "util") in package name.
		ps.execute();
	    connect.commit();
		ps.close();
			
			
			return obj;
			
		}catch ( SQLException e) {
			e.printStackTrace();
			
			return null;
		}
		}
	private Date getDatedebut() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Task update(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set<Task> getAll() {
		System.out.println("hhh");

		    try {
		        Statement stmt = connect.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT * FROM  task");
		        Set<Task> tasks = new HashSet<Task>();
		        
		   	 while ( rs.next() ) {
			   	Task task = new Task(rs.getInt("task_id"),rs.getString("title"),rs.getString("discription"),Task.taskStatuts.valueOf(rs.getString("statut")),rs.getString("Dedline"));
//			   	task.setTask_id(rs.getInt("task_id"));
//			   	task.setTitle( rs.getString("title"));
//			   	task.setDiscription( rs.getString("discription"));
//             	task.setStatut(Task.taskStatuts.valueOf(rs.getString("statut")));
//             	task.setDedline(rs.getString("Dedline"));
//          
			    tasks.add(task);
		        }
				stmt.close();
		        return tasks;

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }

		    return null;
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
	
	
	
	}
