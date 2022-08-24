package com.calculesalaire;

import java.text.DateFormat;
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Locale;  

public class Main {
	
	public static void main(String[] args) {
		//EmployCommission empl1 = new EmployCommission("nawan","hhhh",4000.00,"01/01/2000");
		EmployeFixe emp1 = new EmployeFixe("latifa","AMOUGUAY", 4000.00,"01/01/2000");
		EmployCommission emp2 = new EmployCommission("anas","oussous",	5000.00,"02/01/2000");
		EmployeHoraire emp3 = new EmployeHoraire("YASSIN","ALAMI",	5000.00,"02/07/2000");
		System.out.println("**********************************");
		System.out.println(emp1);
		System.out.println("**********************************");
		System.out.println(emp2);
		System.out.println("**********************************");
		System.out.println(emp3.toString());
		System.out.println("**********************************");
		
		
	
		
	    
	  
	   
		

		
		
		
		
	  
	  
	}

}
