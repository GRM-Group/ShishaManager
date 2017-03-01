package eu.grmdev.sm.core;

import java.io.IOException;

import eu.grmdev.sm.core.sql.SQLExecutor;

public interface DBHandler {
	
	boolean checkConnection();
	
	SQLExecutor execute() throws IOException;
	
	void closeConnection();
	
}