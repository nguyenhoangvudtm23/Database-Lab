import java.sql.*;
import java.time.*;
public class BusinessQuery {
	
	public static String RevenueFromTo(LocalDateTime a, LocalDateTime b)
	{
		return "SELECT SUM(TotalCost) FROM Orders\r\n"
				+ "WHERE CreationDate \r\n"
				+ "BETWEEN '" + DataConverter.TimeToString(a) +"' AND '"
				+ DataConverter.TimeToString(b) + "'";
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Class.forName("org.sqlite.JDBC");
		
		Connection connection = DriverManager.getConnection("jdbc:sqlite:creation.db");
		Statement statement = connection.createStatement();	
		//System.out.println(BusinessQuery.RevenueFromTo(LocalDateTime.now(), LocalDateTime.now()));
		ResultSet result = statement.executeQuery(BusinessQuery.RevenueFromTo(LocalDateTime.MIN, LocalDateTime.now()));
		while (result.next())
		{
			System.out.println(result.getString(1));
		}
	
	}
}
