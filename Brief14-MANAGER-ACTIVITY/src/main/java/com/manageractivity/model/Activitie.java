package com.manageractivity.model;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Cacheable(false)

public class Activitie {
	@Id
    @Column(name = "activitie_Id", columnDefinition = "serial")
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
    

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="responsable_id", nullable = true, columnDefinition = "integer")
    private Responsable responsable;
   
    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "activities_participants", joinColumns = { @JoinColumn(name = "activity_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "participant_id") })
    private Collection<Participant> participants;
}
