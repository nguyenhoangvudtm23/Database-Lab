package Query;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class BusinessQuery {
	
	public static String calculateTotalRevenueFromToQuery(LocalDateTime a, LocalDateTime b)
	{
		return "SELECT SUM(TotalCost) FROM Orders\r\n"
				+ "WHERE (CreationDate \r\n"
				+ "BETWEEN '" + DataConverter.convertDateTimeToString(a) +"' AND '"
				+ DataConverter.convertDateTimeToString(b) + "')\n"
				+ "AND (Status = 'F')";
	}
	public static String calculateTotalCostFromToQuery(LocalDateTime a, LocalDateTime b)
	{
		return "SELECT SUM(TotalCost) FROM BuyOrders\r\n"
				+ "WHERE (CreationDate \r\n"
				+ "BETWEEN '" + DataConverter.convertDateTimeToString(a) +"' AND '"
				+ DataConverter.convertDateTimeToString(b) + "')\n"
				+ "AND (Status = 'F')";
	}
	public static void main(String args[]) throws ClassNotFoundException
	{
		//The format below is the SQLite DateTime normal format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DataConverter.getDateTimeFormat());
		LocalDateTime time = LocalDateTime.parse("2020-02-02 02:02:02", formatter);
		System.out.println(time.toString());
	}
}
