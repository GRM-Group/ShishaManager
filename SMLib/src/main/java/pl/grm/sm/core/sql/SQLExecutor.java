package pl.grm.sm.core.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pl.grm.sm.core.DBHandler;

public class SQLExecutor {
	private DBHandlerImpl dbHandler;
	
	SQLExecutor(DBHandler dbHandler) {
		if (dbHandler instanceof DBHandlerImpl) {
			this.dbHandler = (DBHandlerImpl) dbHandler;
		}
	}
	
	/**
	 * @param user
	 * @param pswd
	 * @param salt
	 * @throws SQLException
	 */
	public void addUser(String user, char[] pswd, String salt)
			throws SQLException {
		PreparedStatement pst = dbHandler.getPS(PreparedStatements.ADDUSER);
		pst.setString(1, user);
		pst.setString(2, new String(pswd));
		pst.setString(3, salt);
		pst.executeUpdate();
	}
	
	public boolean userExists(String user) throws SQLException {
		PreparedStatement pst = dbHandler.getPS(PreparedStatements.CHECKUSER);
		pst.setString(1, user);
		ResultSet rs = pst.executeQuery();
		boolean res = rs.next();
		rs.close();
		return res;
	}
	
	public void dodajMarke(String marka) throws SQLException {
		PreparedStatement pst = dbHandler.getPS(PreparedStatements.ADDCOMPANY);
		pst.setString(1, marka);
		pst.executeUpdate();
	}
	
	public boolean markaIstnieje(String marka) throws SQLException {
		PreparedStatement pst = dbHandler
				.getPS(PreparedStatements.CHECKCOMPANY);
		pst.setString(1, marka);
		ResultSet rs = pst.executeQuery();
		boolean res = rs.next();
		rs.close();
		return res;
	}
	
	public void dodajSmak(String smak) throws SQLException {
		PreparedStatement pst = dbHandler.getPS(PreparedStatements.ADDFLAVOR);
		pst.setString(1, smak);
		pst.executeUpdate();
	}
	
	public boolean smakIstnieje(String smak) throws SQLException {
		PreparedStatement pst = dbHandler.getPS(PreparedStatements.CHECKFLAVOR);
		pst.setString(1, smak);
		ResultSet rs = pst.executeQuery();
		boolean res = rs.next();
		rs.close();
		return res;
	}


}
