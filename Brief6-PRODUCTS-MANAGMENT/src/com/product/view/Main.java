package com.product.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.product.domain.Categories;
import com.product.domain.Product;
import com.product.domain.User;
import com.product.model.DB.DB;
import com.product.model.dao.impl.ProductDao;
import com.product.model.dao.impl.UserDao;

public class Main {
	public static void main(String[] args) {
		
		    System.out.println("choisiez votre opération: ");
			System.out.println("1:Enregistrer ");
			System.out.println("2:Lister les produits ");
			System.out.println("3:Se Loguer ");
			Scanner scn = new Scanner(System.in);
			int oper = scn.nextInt();
		
			 
		
			  UserDao userDao= new UserDao();
			  User userr = new User("admin2", "admin2", "admin1", "admin1", "admin1", "admin1");
		        
			 
			  
	  
			  if(oper==1) {
					 System.out.println("Tapez votre informations svp");
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
			           System.out.println(userDao.create(userr));
				       System.out.println("!Succesfly added");
			  }else if(oper==2) {
				  ProductDao productDao= new ProductDao(); 
				  System.out.print(productDao.voirProduit());
				  
					 
				 }else if(oper==3) {
					 
					 System.out.println("Tapez votre firstname et email svp");
					 System.out.println("Enter your firstname :  ");
					 Scanner inputfirstname = new Scanner(System.in);
					 String firstname = inputfirstname.nextLine();
					 System.out.print("Entrer your email:  ");
					 Scanner inputemail = new Scanner(System.in);
					 String email= inputemail.nextLine();
					 
					 System.out.println( userDao.LogIn(firstname, email));
					 if( userDao.LogIn(firstname, email)==true) {
					
					 System.out.println("Bien Connecter");
					 System.out.println("4: Ajouter le produit");
					 System.out.println("5: Modifier le produit");
					 System.out.println("6: Supprimer le produit");
					 System.out.println("7: Lister les produit");
					 
				
					}else {
						System.out.println(" l'adresse mail ou le username est introuvable");
					}
					 
				 }
			 
			
			
			
			
			
			  
	//      System.out.print(" "+ productDao.voirProduit());
			ProductDao productDao= new ProductDao();    
			Product produit= new Product("NAME", Categories.fruits , 20.00 , 20); 
			Product produit1= new Product("BANANA", Categories.fruits , 20.00 , 20);
			Product produit3= new Product("potato", Categories.vegetables , 20.00 , 20);
			Product produit4= new Product("onion", Categories.vegetables , 20.00 , 20);
			Product produit5= new Product("oranges", Categories.fruits , 20.00 , 20);
			Product produit7= new Product("monga", Categories.fruits , 70.00 , 400);
			
			
			   
	       
		
		
		
  
		
		
		
		 Scanner scn1 = new Scanner(System.in);
			 int oper2 =scn1.nextInt();  
			 if(oper2 == 4) {
		 
				  System.out.println(productDao.ajouter(produit));
				  System.out.println(productDao.ajouter(produit1));
				  System.out.println(productDao.ajouter(produit3));
				  System.out.println(productDao.ajouter(produit7));
		          System.out.println("le produita bien été ajouté");
		           
				 
			 }else if(oper2==5) {
				 productDao.modifierProduit(produit7, 20);
		          Product produitM= new Product("tomatos", Categories.fruits , 4.00 , 20);
		          System.out.println("le produit bien Modifier");
				 
			 }else if(oper2==6) {
				 productDao.delete(7);
		          System.out.println("le produit  a bien été supprimé");
				 
				 
			 }else if(oper2==7) {
				 System.out.println(productDao.voirProduit());
			   
				 
				 
			 }
		
	            
	    	   
		
		
		
       
   
       
	
        
		 }}
		
		
		
	
			

				
			    	 
    
  
    


	

	
	
	

