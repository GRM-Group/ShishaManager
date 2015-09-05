package pl.grm.sm.core.sql;

enum PreparedStatements {
	ADDUSER("INSERT INTO `users`(`username`, `passwd`, `salt`) VALUES (?,?,?)"),
	CHECKUSER("SELECT `username` FROM `users` WHERE `username` = ?"),
	CHECKPSWD("SELECT `username` FROM `users` WHERE `username` = ? AND `passwd` = ?"),
	GETSALT("SELECT `salt` FROM `users` WHERE `username`=?");
	
	private String statement;
	
	PreparedStatements(String statement) {
		this.statement = statement;
	}
	
	String getStatement() {
		return statement;
	}
}
