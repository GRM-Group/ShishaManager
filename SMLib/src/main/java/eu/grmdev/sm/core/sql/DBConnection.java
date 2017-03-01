package eu.grmdev.sm.core.sql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import eu.grmdev.sm.core.DBHandler;

public class DBConnection {
	private String url;
	private String user;
	private String passwd;
	private DBHandler dbHandler;
	private Connection con;
	
	private DBConnection(DBHandler dbHandler) {
		this.dbHandler = dbHandler;
	}
	
	public static DBHandler createNewDBHandler(String confFileName)
			throws IOException {
		if (new File(confFileName).exists()) {
			DBHandlerImpl dbHandler = new DBHandlerImpl();
			DBConnection dbConnection = new DBConnection(dbHandler);
			Properties props = new Properties();
			FileInputStream in = new FileInputStream(confFileName);
			props.load(in);
			dbConnection.setUser(props.getProperty("db.user"));
			dbConnection.setPasswd(props.getProperty("db.passwd"));
			dbConnection.setURL(props.getProperty("db.url"));
			SQLExecutor sqlexec = new SQLExecutor(dbHandler);
			dbHandler.setSQLExecutor(sqlexec);
			dbHandler.setDBConnection(dbConnection);
			dbHandler.checkConnection();
			return dbHandler;
		}
		throw new FileNotFoundException(
				"Couldn't find property file " + confFileName);
	}
	
	public boolean checkConnection() {
		PreparedStatement pst;
		ResultSet rs;
		try {
			initConnection();
			pst = con.prepareStatement("SELECT VERSION()");
			rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeConnection();
			return false;
		}
	}
	
	public void initConnection() throws SQLException {
		if (con == null || con.isClosed()) {
			con = getConnection();
		}
	}
	
	public PreparedStatement prepareStatement(PreparedStatements ps)
			throws SQLException {
		return con.prepareStatement(ps.getStatement());
	}
	
	public void closeConnection() {
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, passwd);
	}
	
	private void setURL(String url) {
		this.url = url;
	}
	
	private void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	private void setUser(String user) {
		this.user = user;
	}
}
