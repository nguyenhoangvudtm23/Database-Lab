
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
	public static void main(String args[]) throws ClassNotFoundException
	{
		
	
	}
}
