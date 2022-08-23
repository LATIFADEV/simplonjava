package com.manageractivity.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


import lombok.Data;
@Entity

@DiscriminatorValue("participant")
public class Participant extends Users {
	
	@Column(name = "domaine")
    private String domaine;

    @Column(name = "structure")
    private String structure;
    @OneToMany(mappedBy="participant")
    private Collection<Activitie> activitie;
   
    
   

}
