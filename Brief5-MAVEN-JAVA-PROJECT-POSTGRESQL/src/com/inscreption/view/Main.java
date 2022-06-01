package com.inscreption.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.inscreption.domain.User;
import com.inscreption.model.DB.DB;
import com.inscreption.model.dao.DAO;
import com.inscreption.model.dao.impl.UserDao;

public class Main {

	public static void main(String[] args) {

	 
		
		
						Scanner inputfirstname = new Scanner(System.in);
						System.out.print("Enter your firstname :  ");
					    String firstname = inputfirstname.nextLine();
						
						Scanner inputlastname = new Scanner(System.in);
						System.out.println("Entrer your lastname:  ");
						String lastname= inputlastname.nextLine();
						
						
						Scanner inputcity = new Scanner(System.in);
						System.out.println("Entrer your city:  ");
						String city= inputcity.nextLine();
						
						
						Scanner inputemail = new Scanner(System.in);
						System.out.println("Entrer your email:  ");
						String email= inputemail.nextLine();
						
						Scanner inputadress = new Scanner(System.in);
						System.out.println("Entrer your adress:  ");
					    String adress= inputadress.nextLine();
						
				       Scanner inputcountry = new Scanner(System.in);
					   System.out.println("Entrer your Country:  ");
				       String country= inputadress.nextLine();
			
			
			
			            UserDao userDao = new UserDao();
			            User condidat2= new User(firstname,  lastname,  email,  adress,  city, country);
			            System.out.println(userDao.create(condidat2));
					
					
//			User condidat1= new User("AMOUGUAY", "Latifa","latifaamouguay@gmail.com","74 rue 22 lotis massira","Tantan","Maroc");
//			User condidat2= new User(3,"RACHID", "najib","najib4@gmail.com","EL HOUDA","AGADIR","Maroc");
//			User condidat2= new User(3,"RACHID", "najib","najib4@gmail.com","EL HOUDA","AGADIR","Maroc");
//			
////		    userDao.create(condidat1);
//		    userDao.create(condidat2);
//		    
////			System.out.println(userDao.create(condidat1));
//			System.out.println(userDao.create(condidat2));
////			boolean result = condidat1.create();
//			
//			if(result) {
//				System.out.println(" User was successfully added!");
//			}
//			else 
//			{
//				System.out.println(" Creation user failed!");
//			}
			
			
			
			
			
//	    UserDao userDao = new UserDao();
//	    User condidat1= new User(1,"AMOUGUAY", "Latifa","latifaamouguay@gmail.com","74 rue 22 lotis massira","Tantan","Maroc");
//	    User condidat2= new User(2,"RACHID", "najib","najib4@gmail.com","EL HOUDA","AGADIR","Maroc");
	    
	    
//	    System.out.println(condidat1);

        
      
        
        
    }
	    

	    
	    
	    
	}


