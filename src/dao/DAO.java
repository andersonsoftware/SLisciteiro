package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAO {

	private Connection connection;

	protected void open() {
		try {
			this.setConnection(ConnectionFactory.getConnection());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	protected void close(ResultSet rs, PreparedStatement stmt) {
		try {
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void close() {
		try {
			this.getConnection().close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}	

}
