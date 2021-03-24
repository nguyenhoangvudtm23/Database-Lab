import java.sql.*;
import java.time.*;
public class BusinessQuery {
	
	public static String calculateRevenueFromToQuery(LocalDateTime a, LocalDateTime b)
	{
		return "SELECT SUM(TotalCost) FROM Orders\r\n"
				+ "WHERE (CreationDate \r\n"
				+ "BETWEEN '" + DataConverter.TimeToString(a) +"' AND '"
				+ DataConverter.TimeToString(b) + "')\n"
				+ "AND (Status = 'F')";
	}
	public static String calculateCostFromToQuery(LocalDateTime a, LocalDateTime b)
	{
		return "SELECT SUM(TotalCost) FROM BuyOrders\r\n"
				+ "WHERE (CreationDate \r\n"
				+ "BETWEEN '" + DataConverter.TimeToString(a) +"' AND '"
				+ DataConverter.TimeToString(b) + "')\n"
				+ "AND (Status = 'F')";
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Class.forName("org.sqlite.JDBC");
		
		Connection connection = DriverManager.getConnection("jdbc:sqlite:creation.db");
		Statement statement = connection.createStatement();	
		System.out.println(BusinessQuery.calculateRevenueFromToQuery(LocalDateTime.MIN, LocalDateTime.now()));
		ResultSet result = statement.executeQuery(BusinessQuery.calculateCostFromToQuery(LocalDateTime.MIN, LocalDateTime.now()));
		while (result.next())
		{
			System.out.println(result.getString(1));
		}
	
	}
}
