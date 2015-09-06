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
	
	public void addUser(String user, char[] pswd, String salt)
			throws SQLException {
		PreparedStatement pst = dbHandler.getPS(PreparedStatements.ADDUSER);
		pst.setString(1, user);
		pst.setString(2, new String(pswd));
		pst.setString(3, salt);
		pst.executeUpdate();
	}
	
	public boolean userExists(String user) throws SQLException {
		PreparedStatement ps = dbHandler.getPS(PreparedStatements.CHECKUSER);
		ps.setString(1, user);
		ResultSet rs = ps.executeQuery();
		boolean res = rs.next();
		rs.close();
		return res;
	}
}
