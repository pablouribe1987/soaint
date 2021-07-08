package Datos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Insertarmensaje {
	
	public void Insertar(String l, Integer t)
	{
		Connection connection = null;
		Conexion conexion = new Conexion();
		
		try {
			connection =conexion.getConecta();
		Statement stmt = connection.createStatement();
		
			stmt.executeUpdate("insert into Log (Mensaje,Valor) Values('" + l + "',"+ String.valueOf(t) + ")");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
