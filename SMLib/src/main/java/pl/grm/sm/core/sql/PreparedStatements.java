package pl.grm.sm.core.sql;

enum PreparedStatements {
	ADD_USER("INSERT INTO `users`(`username`, `passwd`, `salt`) VALUES (?,?,?)"),
	CHECK_USER("SELECT `username` FROM `users` WHERE `username` = ?"),
	CHECK_PSWD("SELECT `username` FROM `users` WHERE `username` = ? AND `passwd` = ?"),
	GET_SALT("SELECT `salt` FROM `users` WHERE `username`=?"),
	ADD_FLAVOR("INSERT INTO `smaki` (`name`) VALUES (?)"),
	ADD_COMPANY("INSERT INTO `marki` (`name`) VALUES (?)"),
	GET_COMPANY_ID("SELECT `id` FROM `marki` WHERE `name` = ?"),
	GET_FLAVOR_ID("SELECT `id` FROM `smaki` WHERE `name` = ?"),
	GET_ALL_TOBACCO("SELECT * FROM `tobacco`"),
	GET_INFO_TOBACCO("SELECT * FROM `tobacco` WHERE `id` = ?"),
	GET_INFO_MEETING(""),
	GET_ALL_MEETINGS(""),
	ADD_MEETING(""),
	
	ADD_SHISHABAR(""),
	GET_ALL_SHISHABARS(""),
	GET_SHISHABAR(""),
	ADD_TOBACCO("INSERT INTO `tytonie` (`marka_id`, `smak_id`) VALUES ((" + GET_COMPANY_ID.getStatement() + "), (" + GET_FLAVOR_ID.getStatement() + "))"),
	GET_TOBACCO_ID("SELECT `id` FROM `tytonie` WHERE `marka_id` = (" + GET_COMPANY_ID.getStatement() + ") AND `smak_id` =  (" + GET_FLAVOR_ID.getStatement() + ")"),
	ADD_TOBACCO_DATA("INSERT INTO `user_tobacco_data` (`user_id`, `tyton_id`, `ocena_dym`, `ocena_smak`,`czas_palenia`,`cena`,`opis`) VALUES ((SELECT `id` FROM `users` WHERE `username` = ?),("
			+ GET_TOBACCO_ID.getStatement() + ") , ?, ?, ?, ?, ?)"),
	GET_TOBACCO_DATA_ID("SELECT `id` FROM `user_tobacco_data` WHERE `tyton_id` = (" + GET_TOBACCO_ID.getStatement() + ")");
	
	private String statement;
	
	PreparedStatements(String statement) {
		this.statement = statement;
	}
	
	String getStatement() {
		return statement;
	}
}
