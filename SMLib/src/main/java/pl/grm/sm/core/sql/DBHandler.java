package pl.grm.sm.core.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHandler {

	private DBConnection dbConnection;

	void setDBConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public boolean checkConnection() {
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement("SELECT VERSION()");
			rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
