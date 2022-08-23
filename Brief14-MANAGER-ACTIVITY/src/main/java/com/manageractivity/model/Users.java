package com.manageractivity.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import lombok.Data;
@Entity
@Data
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="Roles")
public class Users {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 
	   @Column(name = "nom")
	    private String nom;

	    @Column(name = "prenom")
	    private String prenom;

	    @Column(name = "telephone")
	    private String telephone;

	    @Column(name = "email")
	    private String email;

	    @Column(name = "login")
	    private String login;

	    @Column(name = "pasword")
	    private String pasword;

	 
	 
	 



}
