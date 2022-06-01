package com.inscreption.model.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inscreption.domain.User;

public class DB {
	
	   /*
     * URL de connexion
     */
    private static String url = "jdbc:postgresql://localhost:5432/db_login";
    /*
     * Nom du user
     */
    private static String user = "postgres";
    /*
     * Mot de passe du user
     */
    private static String passwd = "root";
    /*
     * Objet Connexion
     */
    private static Connection connect;
    
    /*
     * M�thode qui va nous retourner notre instance
     * et la cr�er si elle n'existe pas...
     * @return
     */
    public static Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }        
        return connect;    
    } 
		
		
		
		
		
		
	}
	
