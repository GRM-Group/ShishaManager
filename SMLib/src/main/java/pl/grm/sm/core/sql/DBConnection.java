package pl.grm.sm.core.sql;

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

public class DBConnection {
	private DBHandler dbHandler;
	private String url;
	private String passwd;
	private String user;
	private Connection con;
	
	private DBConnection(DBHandler dbHandler) {
		this.dbHandler = dbHandler;
	}
	
	public static DBHandler createNewDBHandler(String confFileName)
			throws IOException {
		if (new File(confFileName).exists()) {
			DBHandler dbHandler = new DBHandler();
			DBConnection dbConnection = new DBConnection(dbHandler);
			Properties props = new Properties();
			FileInputStream in = new FileInputStream(confFileName);
			props.load(in);
			dbConnection.setUser(props.getProperty("db.user"));
			dbConnection.setPasswd(props.getProperty("db.passwd"));
			dbConnection.setURL(props.getProperty("db.url"));
			dbHandler.setDBConnection(dbConnection);
			dbHandler.checkConnection();
			return dbHandler;
		}
		throw new FileNotFoundException(
				"Couldn't find property file " + confFileName);
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
	
	Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, passwd);
	}
	
	public void initConnection() throws SQLException {
		if (con == null || con.isClosed()) {
			con = getConnection();
		}
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
	
	public PreparedStatement prepareStatement(PreparedStatements ps)
			throws SQLException {
		return con.prepareStatement(ps.getStatement());
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
}
