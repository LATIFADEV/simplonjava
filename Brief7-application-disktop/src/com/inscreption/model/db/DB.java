package com.inscreption.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			* Méthode qui va nous retourner notre instance
			* et la créer si elle n'existe pas...
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
			public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
		        //Declare statement, resultSet and CachedResultSet as null
		        Statement stmt = null;
		        ResultSet resultSet = null;
		        
		        try {
		            //Connect to DB (Establish Oracle Connection)
		        	getInstance();
		            System.out.println("Select statement: " + queryStmt + "\n");
		            //Create statement
		            stmt = connect.createStatement();
		            //Execute select (query) operation
		            resultSet = stmt.executeQuery(queryStmt);
		            //CachedRowSet Implementation
		            //In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
		            //We are using CachedRowSet
		        } catch (SQLException e) {
		            System.out.println("Problem occurred at executeQuery operation : " + e);
		            throw e;
		        } finally {
		            if (resultSet != null) {
		                //Close resultSet
		                resultSet.close();
		            }
		            if (stmt != null) {
		                //Close Statement
		                stmt.close();
		            }
		            //Close connection
		           connect.close();
		        }
		        //Return CachedRowSet
				return resultSet;
		        
		    }
				

}
