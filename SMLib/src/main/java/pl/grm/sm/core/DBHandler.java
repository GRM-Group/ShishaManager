package pl.grm.sm.core;

import java.io.IOException;

import pl.grm.sm.core.sql.SQLExecutor;

public interface DBHandler {
	
	boolean checkConnection();
	
	SQLExecutor execute() throws IOException;
	
	void closeConnection();
	
}