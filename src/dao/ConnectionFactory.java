package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException {		
		try {
			Class.forName("org.postgresql.Driver");//For�ando a inicializacao do drive
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/slisciteiro", "postgres","postgres");
		}catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}	
	}
}
