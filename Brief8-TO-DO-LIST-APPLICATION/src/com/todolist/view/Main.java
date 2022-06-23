package com.todolist.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


import com.todolist.domin.Task;
import com.todolist.domin.User;
import com.todolist.model.dao.impl.TaskDAO;
import com.todolist.model.dao.impl.UserDAO;

public class Main {
  public static void main(String[] args ) throws ParseException {
	  System.out.println("gggg");
	
//		Scanner inputbirthdate = new Scanner(System.in);
//		System.out.println("Entrer your datedebut:  ");
//		String datedebut= inputbirthdate.nextLine();
//		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
//		java.util.Date udob = sdf.parse(datedebut);
//		long ms= udob.getTime();
//		java.sql.Date sqdob = new java.sql.Date(ms);
	  
		
		
//	  UserDAO userDao = new UserDAO();
//	  User user = new User(2,"admin","admin","admin","root");
//	  System.out.println(userDao.create(user));
//	  
//	  System.out.println("Enter your username :  ");
//		 Scanner inputusrname = new Scanner(System.in);
//		 String username = inputusrname.nextLine();
//		 System.out.print("Entrer your password:  ");
//		 Scanner inputpassword = new Scanner(System.in);
//		 String password= inputpassword.nextLine();
//		 
//		 System.out.println( userDao.login(username, password));
//		 if( userDao.login(username, password)==true) {
//		 System.out.println("Bien Connecter");
	  
//} 
	  
	  
	  
	  TaskDAO taskDao= new TaskDAO();
	  
//	  Task tsk= new Task(  5, "javafx","projet to do list dao ","In_progress","01/02/2022");
//	  System.out.println(taskDao.create(tsk));
//	  System.out.println(taskDao.getAll());
  }
	  
}
