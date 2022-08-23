package com.manageractivity.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Cacheable(false)
@Data
@DiscriminatorValue("responsable")
public class Responsable extends Users {
	@Column(name = "domain")
    private String domain;

    @Column(name = "type")
    private String type;

    @Column(name = "etat")
    private String etat;
    
    
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "responsable_id", nullable = true, columnDefinition = "integer")
    private Collection<Activitie> activities;
    
    
    

}
