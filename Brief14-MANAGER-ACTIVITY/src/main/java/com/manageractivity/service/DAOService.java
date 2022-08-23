package com.manageractivity.service;

import java.util.List;

import com.manageractivity.model.Users;

public interface DAOService <T>{
	/*
     * Permet de récupérer un objet via son ID
     * @param id
     * @return
     */
    public abstract T find(long id);
    
    /*
     * Permet de créer une entrée dans la base de données
     * par rapport à un objet
     * @param obj
     */
    public abstract T create(T obj);
    
    /*
     * Permet de mettre à jour les données d'une entrée dans la base 
     * @param obj
     */
    public abstract T update(T obj);
    
    /*
     * Permet la suppression d'une entrée de la base
     * @param obj
     */
    public void delete(int id);
    /*
     * Permet la récupérer d'une entrée de la base par son id
     * @param obj
     */
    public abstract T getById(int id);
    /*
     * Permet la récupérer touts les entrée de la base par 
     * @param obj
     */
    public abstract  List<T> getAll();
}
