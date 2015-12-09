package pl.grm.sm.core.sql;

enum PreparedStatements {
	ADDUSER("INSERT INTO `users`(`username`, `passwd`, `salt`) VALUES (?,?,?)"),
	CHECKUSER("SELECT `username` FROM `users` WHERE `username` = ?"),
	CHECKPSWD("SELECT `username` FROM `users` WHERE `username` = ? AND `passwd` = ?"),
	GETSALT("SELECT `salt` FROM `users` WHERE `username`=?"),
	GETALLTOBACCO("SELECT * FROM `tobacco`"),
	GETINFOTOBACCO("SELECT * FROM `tobacco` WHERE `id` = ?"),
	GETINFOMEETING(""),
	GETALLMEETINGS(""),
	ADDMEETING(""),
	ADDTOBACCODATA("INSERT INTO `user_tobacco_data` (`user_id`, `tyton_id`, `ocena_dym`, `ocena_smak`,`czas_palenia`,`cena`,`opis`) VALUES ((SELECT `id` FROM `users` WHERE `username` = ?), ?, ?, ?, ?, ?,?)"),
	ADDSHISHABAR(""),
	GETALLSHISHABARS(""),
	GETSHISHABAR(""),
	ADDTOBACCO("INSERT INTO `tytonie` (`marka_id`, `smak_id`) VALUES ((SELECT `id` FROM `marki` WHERE `name` = ?), (SELECT `id` FROM `smaki` WHERE `name` = ?))"),
	GET_TOBACCO_ID("SELECT `id` FROM `tytonie` WHERE `marka_id` = (SELECT `id` FROM `marki` WHERE `name` = ?) AND `smak_id` =  (SELECT `id` FROM `smaki` WHERE `name` = ?)"),
	ADDFLAVOR("INSERT INTO `smaki` (`name`) VALUES (?)"),
	ADDCOMPANY("INSERT INTO `marki` (`name`) VALUES (?)"),
	GET_COMPANY_ID("SELECT `id` FROM `marki` WHERE `name` = ?"),
	GET_FLAVOR_ID("SELECT `id` FROM `smaki` WHERE `name` = ?");
	
	private String statement;
	
	PreparedStatements(String statement) {
		this.statement = statement;
	}
	
	String getStatement() {
		return statement;
	}
}
