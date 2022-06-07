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
		int UserId=0;
		UserDao userDao = new UserDao();
		
		 	
	                    Scanner reader= new Scanner(System.in);
						Scanner scn = new Scanner(System.in);
						System.out.println("choisiez votre opération: ");
						System.out.println("1: Enregistrer");
						System.out.println("2: Modifier");
						System.out.println("3: Supprimer");
					    int oper = scn.nextInt();
		

						
				       
				       
				      
			
				       if(oper==1) {
				    	   Scanner inputfirstname = new Scanner(System.in);
							System.out.print("Enter your firstname :  ");
						    String firstname = inputfirstname.nextLine();
							
							Scanner inputlastname = new Scanner(System.in);
							System.out.print("Entrer your lastname:  ");
							String lastname= inputlastname.nextLine();
							
							
							Scanner inputcity = new Scanner(System.in);
							System.out.print("Entrer your city:  ");
							String city= inputcity.nextLine();
							
							
							Scanner inputemail = new Scanner(System.in);
							System.out.print("Entrer your email:  ");
							String email= inputemail.nextLine();
							
							Scanner inputadress = new Scanner(System.in);
							System.out.print("Entrer your adress:  ");
						    String adress= inputadress.nextLine();
							
					       Scanner inputcountry = new Scanner(System.in);
						   System.out.print("Entrer your Country:  ");
					       String country= inputadress.nextLine();
				    	
				            User condidat= new User(firstname,  lastname,  email,  adress,  city, country);
				            System.out.println(userDao.create(condidat));  
				    	   
				       }else if(oper==2) {
				    	   Scanner inputfirstname = new Scanner(System.in);
							System.out.print("Enter your firstname :  ");
						    String firstname = inputfirstname.nextLine();
							
							Scanner inputlastname = new Scanner(System.in);
							System.out.print("Entrer your lastname:  ");
							String lastname= inputlastname.nextLine();
							
							
							Scanner inputcity = new Scanner(System.in);
							System.out.print("Entrer your city:  ");
							String city= inputcity.nextLine();
							
							
							Scanner inputemail = new Scanner(System.in);
							System.out.print("Entrer your email:  ");
							String email= inputemail.nextLine();
							
							Scanner inputadress = new Scanner(System.in);
							System.out.print("Entrer your adress:  ");
						    String adress= inputadress.nextLine();
							
					       Scanner inputcountry = new Scanner(System.in);
						   System.out.print("Entrer your Country:  ");
					       String country= inputadress.nextLine();
				    	   
				    	   User condidat = new User(firstname,  lastname,  email,  adress,  city, country);				    	    
				    		System.out.println(userDao.update(condidat));
				    	   
				       }else if(oper==3) {	
				    	   
				    	  
							do{
								
								System.out.println("Enter Candidate Id: ");
							    UserId = reader.nextInt();
								System.out.println("Candidate Exist!");
								if(userDao.delete(UserId)) {
									System.out.println("Candidate Deleted SuccessFuly!");
								}
							}
							while(!userDao.delete(UserId));
						

						}else {
							
							
							reader.close();	
					} while (true);
				

					
				    	 
				    
	
	
}
    }
	    

	    
	    
	    
	


