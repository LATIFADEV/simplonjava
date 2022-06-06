package com.product.model.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
    private static String driver = "org.postgresql.Driver";

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
     * Méthode qui va nous retourner notre instance
     * et la créer si elle n'existe pas...
     * @return
     */
    public static Connection getInstance() {
        if(connect == null){
            try {
            	Class.forName(driver);
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }        
        return connect;    

}}
