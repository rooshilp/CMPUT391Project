package db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The Database class implements all database connectivity functions. It is used
 * by any class that requires a connection to the database.
 * 
 * @author tyleung
 * 
 */
public class Database {

	private Connection conn;
	private String username;
	private String password;

	public Database() {
		conn = null;
		username = "tyleung";
		password = "cmput391";
	}

	/**
	 * Connect to the database.
	 */
	public void connect() {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		// Use this dbstring to connect to the campus databases from home
		//String dbstring = "jdbc:oracle:thin:@localhost:1525:CRS";
		String dbstring = "jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";

		try {
			// load and register the driver
			Class<?> drvClass = Class.forName(driverName);
			DriverManager.registerDriver((Driver) drvClass.newInstance());
		} catch (Exception e) {
			System.out.println("<hr>" + e.getMessage() + "<hr>");
		}

		try {
			// establish the connection
			conn = DriverManager.getConnection(dbstring, username, password);
			conn.setAutoCommit(false);
		} catch (Exception e) {
			System.out.println("<hr>" + e.getMessage() + "<hr>");
		}

	}

	/**
	 * Get the database connection
	 * 
	 * @return conn the connection
	 */
	public Connection getConnection() {
		return conn;
	}

	/**
	 * Close the database
	 * 
	 * @param conn
	 *            the connection
	 * @param stmt
	 *            the statement
	 * @param pstmt
	 *            the prepared statement
	 * @param rset
	 *            the result set
	 */
	public void close(Connection conn, Statement stmt, PreparedStatement pstmt,
			ResultSet rset) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rset != null) {
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
