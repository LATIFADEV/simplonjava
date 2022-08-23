package com.manageractivity.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
@DiscriminatorValue("admins")
public class Admins extends Users {
	@Column(name = "etat")
    private String etat;
	


}
