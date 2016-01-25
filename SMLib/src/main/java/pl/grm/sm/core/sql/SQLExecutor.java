package pl.grm.sm.core.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

import pl.grm.sm.core.DBHandler;
import pl.grm.sm.core.DaneTytoniu;

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
		PreparedStatement pst = dbHandler.getPS(PreparedStatements.ADD_USER);
		pst.setString(1, user);
		pst.setString(2, new String(pswd));
		pst.setString(3, salt);
		pst.executeUpdate();
	}
	
	public boolean userExists(String user) throws SQLException {
		PreparedStatement pst = dbHandler.getPS(PreparedStatements.CHECK_USER);
		pst.setString(1, user);
		ResultSet rs = pst.executeQuery();
		boolean res = rs.next();
		rs.close();
		return res;
	}
	
	public void dodajMarke(String marka) throws SQLException {
		PreparedStatement pst = dbHandler.getPS(PreparedStatements.ADD_COMPANY);
		pst.setString(1, marka);
		pst.executeUpdate();
	}
	
	public boolean markaIstnieje(String marka) throws SQLException {
		PreparedStatement pst = dbHandler
				.getPS(PreparedStatements.GET_COMPANY_ID);
		pst.setString(1, marka);
		ResultSet rs = pst.executeQuery();
		boolean res = rs.next();
		rs.close();
		return res;
	}
	
	public void dodajSmak(String smak) throws SQLException {
		PreparedStatement pst = dbHandler.getPS(PreparedStatements.ADD_FLAVOR);
		pst.setString(1, smak);
		pst.executeUpdate();
	}
	
	public boolean smakIstnieje(String smak) throws SQLException {
		PreparedStatement pst = dbHandler.getPS(PreparedStatements.GET_FLAVOR_ID);
		pst.setString(1, smak);
		ResultSet rs = pst.executeQuery();
		boolean res = rs.next();
		rs.close();
		return res;
	}


	public void dodajTyton(String marka, String smak) throws SQLException {
		PreparedStatement pst = dbHandler.getPS(PreparedStatements.ADD_TOBACCO);
		pst.setString(1, marka);
		pst.setString(2, smak);
		pst.executeUpdate();
		
	}
	
	public boolean tytonIstnieje(String marka, String smak)
			throws SQLException {
		PreparedStatement pst = dbHandler
				.getPS(PreparedStatements.GET_TOBACCO_ID);
		pst.setString(1, marka);
		pst.setString(2, smak);
		ResultSet rs = pst.executeQuery();
		boolean res = rs.next();
		rs.close();
		return res;
	}
	
	public void dodajDaneTytoniu(String marka, String smak, int ocenaDymu, int ocenaSmaku, int czasPalenia, double cena, String opis)
			throws SQLException {
		PreparedStatement pst = dbHandler.getPS(PreparedStatements.ADD_TOBACCO_DATA);
		pst.setString(1, "wincenty");
		pst.setString(2, marka);
		pst.setString(3, smak);
		pst.setInt(4, ocenaDymu);
		pst.setInt(5, ocenaSmaku);
		pst.setInt(6, czasPalenia);
		pst.setDouble(7, cena);
		pst.setString(8, opis);
		pst.executeUpdate();
			
	}

	public boolean daneTytoniuIstnieje(String marka, String smak)
			throws SQLException {
		PreparedStatement pst = dbHandler
				.getPS(PreparedStatements.GET_TOBACCO_DATA_ID);
		pst.setString(1, marka);
		pst.setString(2, smak);
		ResultSet rs = pst.executeQuery();
		boolean res = rs.next();
		rs.close();
		return res;
	}
	
	public TreeMap<Integer, DaneTytoniu> pobierzListe() throws SQLException {
		PreparedStatement pst = dbHandler
				.getPS(PreparedStatements.GET_TOBACCO_DATA_LIST_ALL);
		ResultSet rs = pst.executeQuery();
		TreeMap<Integer, DaneTytoniu> map = new TreeMap<>();
		while (rs.next()) {
			DaneTytoniu x = new DaneTytoniu(rs.getString("marka"),
					rs.getString("smak"), rs.getDouble("ocena_ogolna"),
					rs.getDouble("cena"));
			map.put(rs.getInt(0), x);
		}
		return map;
	};
	
}
