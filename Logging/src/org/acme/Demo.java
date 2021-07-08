package org.acme;


import java.text.DateFormat;
import java.util.Date;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import Datos.Insertarmensaje;


public class Demo {

	 private static boolean logToFile;
	    private static boolean logMessage;
	    private static boolean logWarning;
	    private static boolean logError;
	    private static boolean logToDatabase;
	    private static Logger logger;
	    
	    public Demo(boolean logToFileParam, boolean logToDatabaseParam,
             boolean logMessageParam, boolean logWarningParam, boolean logErrorParam) {
     logger = Logger.getLogger("MyLog");
     logError = logErrorParam;
     logMessage = logMessageParam;
     logWarning = logWarningParam;
     logToDatabase = logToDatabaseParam;
     logToFile = logToFileParam;
    
	    	}
	    
	    public static void LogMessage(String messageText, boolean message, boolean warning, boolean error) throws Exception {
	        messageText.trim();
	        if (messageText == null || messageText.length() == 0) {
	            return;
	        }
	        if ( !logToFile && !logToDatabase) {
	            throw new Exception("Invalid configuration");
	        }

	        if ((!logError && !logMessage && !logWarning) || (!message && !warning && !error)) {
	            throw new Exception("Error or Warning or Message must be specified");
	        }

	     
	     // t no me sirve
	        	int t = 0;
		    
		        if (message && logMessage) {
		            t = 1;
		        }

		        if (error && logError) {
		            t = 2;
		        }

		        if (warning && logWarning) {
		            t = 3;
		        }
	        

		        String l = "";
		        String espacio="";
		     
		     
		        FileHandler fh = new FileHandler(Getproperties.getConexion().getProperty("logFileFolder").toString() + "/logFile.txt");
		   
		      
		        int contador=0;
		        if (error && logError) {
		        	
		            l = l + "error: " + messageText+", " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date());
		            contador=1;
		        }

		   
		        if (warning && logWarning) {
		        	if (contador>0)
		        	{
		        	 espacio  ="; ";
		        	}
		        	else {
		        		contador =1; 
		        	}
		        	
		            l = l + espacio+"warning: "+ messageText+", " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date());
		        }

		        if (message && logMessage) {
		        	if (contador>0)
		        	{
		        	 espacio  ="; ";
		        	}
		            l = l +espacio+ "message: " + messageText+", "+DateFormat.getDateInstance(DateFormat.LONG).format(new Date());
		        }
		          
		        if(logToFile && message) {
		            logger.addHandler(fh);
		            logger.log(Level.INFO,messageText);
		        }
		         if(logToFile && error ) {
		            logger.addHandler(fh);
		            logger.log(Level.SEVERE,messageText);
		        }
		         if(logToFile && warning) {
			            logger.addHandler(fh);
			            logger.log(Level.WARNING,messageText);
			        }
		         
		    
		      
	        if(logToDatabase) {
	          
	        	Insertarmensaje inserta = new Insertarmensaje();
	        	inserta.Insertar(l, t);
	        }
	        
		    	
	    }
	
}
