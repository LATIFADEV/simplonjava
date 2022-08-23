package com.manageractivity.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
@DiscriminatorValue("responsable")
public class Responsable extends Users {
		@Column(name = "domaine")
	    private String domaine;

	    @Column(name = "type")
	    private String type;

	    @Column(name = "etat")
	    private String etat;

}
