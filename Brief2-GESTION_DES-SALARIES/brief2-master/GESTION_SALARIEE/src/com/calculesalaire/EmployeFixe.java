package com.calculesalaire;

import java.util.Date;

public class EmployeFixe  extends Employes{
	
	public EmployeFixe(String firstname, String lastname, double salaire,  String strDate) {
		super(firstname, lastname, salaire, strDate);
		
	}


	@Override
	public double calculerSalaire() {
		 return super.getSalaire();
		
		
	}
	public String toString() {
		 return "L'Employes Fixe:"+"\n\t First Name :" + getFirstname() + "\n\t Last Name:" + getLastname() +"\n\t Datebirth:"
					+ strDate+ "\n\t Salaire:" +getSalaire() + "";
	}

	

}
