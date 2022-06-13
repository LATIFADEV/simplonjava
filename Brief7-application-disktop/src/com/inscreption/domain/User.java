package com.inscreption.domain;

import java.util.Objects;

public class User {
	//integer
	private int idUser;
	private String firstname;
	private String lastname;
	private String email;
	private String adresse;
	private String city;
	private String country;
	
	
	public User() {
		
	}
	
	public User(String firstname, String lastname, String email, String adress, String city,
			String country) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.adresse = adress;
		this.city = city;
		this.country = country;

	}
	
	public User(int id, String firstname, String lastname, String email, String adress, String city,
			String country) {
		this.idUser = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.adresse = adress;
		this.city = city;
		this.country = country;

	}


	@Override
	public int hashCode() {
		return Objects.hash(adresse, city, country, email, firstname, idUser, lastname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(city, other.city)
				&& Objects.equals(country, other.country) && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && idUser == other.idUser
				&& Objects.equals(lastname, other.lastname);
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
		return "User [idUser=" + idUser + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", adresse=" + adresse + ", city=" + city + ", country=" + country + "]";
	}





}
