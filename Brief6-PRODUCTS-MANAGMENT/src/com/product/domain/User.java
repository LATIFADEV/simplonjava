package com.product.domain;

public class User {
	private int idUser;
	private String firstname,lastname,email,adresse,city,country;
	
	public User( String firstname, String lastname, String email, String adress, String city,
			String country) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.adresse = adress;
		this.city = city;
		this.country = country;

	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}



	@Override
	public String toString() {
		return "firstname: " + firstname + "  lastname: " + lastname + "  email: " + email + "  adresse: " + adresse
				+ "  city: " + city + "  country: " + country + "";
	}

}
