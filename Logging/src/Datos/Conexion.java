package Datos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.acme.Getproperties;

public class Conexion {
	
	public Connection getConecta()
	{
		
		  Connection connection = null;
	        
	        try {
				connection = DriverManager.getConnection("jdbc:" + Getproperties.getConexion().getProperty("dbms").toString()+
						"://" + Getproperties.getConexion().getProperty("serverName").toString()
				        + ":" + Getproperties.getConexion().getProperty("portNumber").toString(),Getproperties.getCredenciales());
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return connection;
		
	}
}
