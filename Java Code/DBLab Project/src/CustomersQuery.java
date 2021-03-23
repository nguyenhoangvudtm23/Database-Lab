import java.sql.*;
public class CustomersQuery {
	public static String SortByTotalDesc(int limit)
	{
		return "SELECT C.CustomerID, SUM(O.TotalCost) AS Total\r\n"
				+ "FROM Customers C JOIN Orders O\r\n"
				+ "ON C.CustomerID = O.CustomerID\r\n"
				+ "GROUP BY C.CustomerID\r\n"
				+ "ORDER BY Total DESC\r\n"
				+ "LIMIT " + Integer.toString(limit);
	}
	public static String CustomerTotalSpend(int ID)
	{
		return "SELECT SUM(O.TotalCost) AS Total\r\n"
				+ "FROM Orders O\r\n"
				+ "WHERE CustomerID = " + Integer.toString(ID);
	}
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("org.sqlite.JDBC");
		
		Connection connection = DriverManager.getConnection("jdbc:sqlite:creation.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(23);
		
		//TESTING PURPOSE
		//statement.executeUpdate("insert into Orders\r\n"
		//		+ "VALUES (1, 1, 0.5, \"2020-02-02 01:00:21\", \"C\", 0)");
		
		ResultSet result = statement.executeQuery(CustomersQuery.SortByTotalDesc(1));
		while (result.next())
		{
			System.out.println(result.getString("Total"));
		}
	}
}
