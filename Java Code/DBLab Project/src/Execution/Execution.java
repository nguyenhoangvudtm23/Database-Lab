package Execution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Execution {
	static Statement statement;
	static Connection connection = null;
	public static void getConnection() throws SQLException, ClassNotFoundException 
	{
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:creation.db");
		statement = connection.createStatement();
        statement.setQueryTimeout(30); 
	}
	
}
