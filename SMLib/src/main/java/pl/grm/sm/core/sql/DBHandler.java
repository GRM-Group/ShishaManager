package pl.grm.sm.core.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHandler {
	
	private DBConnection dbConnection;
	
	void setDBConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	public boolean checkConnection() {
		return dbConnection.checkConnection();
	}
	
	public void addUser(String user, char[] pswd, String salt)
			throws SQLException {
		if (checkConnection()) {
			PreparedStatement pst = getPS(PreparedStatements.ADDUSER);
			pst.setString(1, user);
			pst.setString(2, new String(pswd));
			pst.setString(3, salt);
			pst.executeUpdate();
		}
	}
	
	private PreparedStatement getPS(PreparedStatements ps) throws SQLException {
		checkConnection();
		return dbConnection.prepareStatement(ps);
	}
	
	public boolean userExists(String user) throws SQLException {
		PreparedStatement ps = getPS(PreparedStatements.CHECKUSER);
		ps.setString(1, user);
		ResultSet rs = ps.executeQuery();
		boolean res = rs.next();
		rs.close();
		return res;
	}
	
	public void closeConnection() {
		dbConnection.closeConnection();
	}
}
