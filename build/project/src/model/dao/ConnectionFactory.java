package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static String url = "jdbc:postgresql://localhost:5432/Agenda";
	private static String user = "postgres";
	private static String password = "25731007";
	
	
	//Objet Connection priv� et variable de classe
	
	private static Connection connect;
	

	 //M�thode qui va nous retourner notre instance et la cr�er si elle n'existe pas
	  public static Connection getInstance() {
		  if(connect == null) 
			  try {
					connect = DriverManager.getConnection(url, user, password);
					
			  } catch (Exception e) {
					  e.printStackTrace();
			  }
		  return connect;
	  }
}

