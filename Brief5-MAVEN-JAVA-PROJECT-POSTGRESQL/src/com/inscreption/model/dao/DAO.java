package com.inscreption.model.dao;

import java.sql.Connection;
import java.util.List;

import com.inscreption.model.DB.DB;
 
public interface  DAO<T> {

    public Connection connect = DB.getInstance();
    
    /*
     * Permet de r�cup�rer un objet via son ID
     * @param id
     * @return
     */
    public abstract T find(long id);
    
    /*
     * Permet de cr�er une entr�e dans la base de donn�es
     * par rapport � un objet
     * @param obj
     */
    public abstract T create(T obj);
    
    /*
     * Permet de mettre � jour les donn�es d'une entr�e dans la base 
     * @param obj
     */
    public abstract T update(T obj);
    
    /*
     * Permet la suppression d'une entr�e de la base
     * @param obj
     */
    public boolean delete(int id);


}



















