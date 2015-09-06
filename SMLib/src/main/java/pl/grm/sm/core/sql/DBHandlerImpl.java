package pl.grm.sm.core.sql;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pl.grm.sm.core.DBHandler;

public class DBHandlerImpl implements DBHandler {
	
	private DBConnection dbConnection;
	private SQLExecutor sqlexec;
	
	public DBHandlerImpl() {
	}
	
	@Override
	public boolean checkConnection() {
		return dbConnection.checkConnection();
	}
	
	@Override
	public SQLExecutor execute() throws IOException {
		if (checkConnection()) {
			return sqlexec;
		} else {
			throw new IOException("Couldn't connect to DB!");
		}
	}
	
	PreparedStatement getPS(PreparedStatements ps) throws SQLException {
		checkConnection();
		return dbConnection.prepareStatement(ps);
	}
	
	@Override
	public void closeConnection() {
		dbConnection.closeConnection();
	}
	
	void setDBConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	void setSQLExecutor(SQLExecutor sqlexec) {
		this.sqlexec = sqlexec;
	}
}
