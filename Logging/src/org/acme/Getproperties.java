package org.acme;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Getproperties {

	
	public static Properties getConexion()
	{
		
		Properties config = new Properties();
	    InputStream configInput = null;
	    
	    try{ 
	    configInput = new FileInputStream("connectionProps.properties");
	    config.load(configInput);
	     } catch(Exception ex){
		      System.out.println(ex);
		 }
	    
		return config;
		
	}
	
	public static Properties getCredenciales()
	{
		
		Properties config = new Properties();
	    InputStream configInput = null;
	    
	    try{ 
	    configInput = new FileInputStream("credenciales.properties");
	    config.load(configInput);
	     } catch(Exception ex){
		      System.out.println(ex);
		 }
	    
		return config;
		
	}
	

	
	
}
