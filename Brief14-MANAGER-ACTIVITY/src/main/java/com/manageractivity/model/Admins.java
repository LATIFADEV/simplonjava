package com.manageractivity.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
@Cacheable(false)
@DiscriminatorValue("admins")
public class Admins extends Users {
	@Column(name = "etat")
    private String etat;
	


}
