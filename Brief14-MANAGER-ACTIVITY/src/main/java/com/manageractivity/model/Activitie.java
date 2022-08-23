package com.manageractivity.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

public class Activitie {
	@Id
    @Column(name = "activite_Id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activite_Id;

    @Column(name = "DateDebut")
    private Date DateDebut;

    @Column(name = "DateFin")
    private Date DateFin;

    @Column(name = "titre")
    private String titre;

    @Column(name = "descriptif")
    private String descriptif;

    @Column(name = "type")
    private String type;

    @Column(name = "etat")
    private String etat;
    @ManyToOne
    private Participant participant;
    
   
}
