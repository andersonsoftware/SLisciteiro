package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class DAO{

	private Connection conn;
	
	public DAO(){
		try {
			conn = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		

	protected void close(ResultSet rs, PreparedStatement stmt){
		try {
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	
	public void close(){
		try {
			getConn().close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	
	public Connection getConn() {
		return conn;
	}	
	
}
