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
	public static String calculateAverageSpendPerOrderFromToQuery(LocalDateTime from, LocalDateTime to)
	{
		return "select avg(Totalcost) from Orders"
				+ "\nwhere CreationDate between '" + DataConverter.convertDateTimeToString(from) + "' AND '"
				+ DataConverter.convertDateTimeToString(to) + "'";
	}
	public static String calculateTotalRevenueLastXYearsQuery(int x)
	{
		return "select strftime('%Y', CreationDate), sum(Totalcost) from Orders\r\n"
				+ "where CreationDate BETWEEN date('" + DataConverter.convertDateTimeToString(LocalDateTime.now().minusYears(x)) 
				+  "') AND date('" + DataConverter.convertDateTimeToString(LocalDateTime.now()) + "')\r\n"
				+ "GROUP BY strftime('%Y', CreationDate)";
	}
	public static String calculateTotalRevenueLastXMonthsQuery(int x)
	{
		return "select strftime('%Y-%m', CreationDate), sum(Totalcost) from Orders\r\n"
				+ "where CreationDate BETWEEN date('" + DataConverter.convertDateTimeToString(LocalDateTime.now().minusMonths(x)) 
				+  "') AND date('" + DataConverter.convertDateTimeToString(LocalDateTime.now()) + "')\r\n"
				+ "GROUP BY strftime('%Y-%m', CreationDate)";
	}
	public static String calculateTotalRevenueLastXWeeksQuery(int x)
	{
		return "select strftime('%Y-%W', CreationDate), sum(Totalcost)  from Orders\r\n"
				+ "where CreationDate BETWEEN date('" + DataConverter.convertDateTimeToString(LocalDateTime.now().minusWeeks(x)) 
				+  "') AND date('" + DataConverter.convertDateTimeToString(LocalDateTime.now()) + "')\r\n"
				+ "GROUP BY strftime('%W', CreationDate)";
	}
	public static String calculateTotalRevenueLastXDaysQuery(int x)
	{
		return "select strftime('%d-%m-%Y', CreationDate), sum(Totalcost) from Orders\r\n"
				+ "where CreationDate BETWEEN date('" + DataConverter.convertDateTimeToString(LocalDateTime.now().minusDays(x)) 
				+  "') AND date('" + DataConverter.convertDateTimeToString(LocalDateTime.now()) + "')\r\n"
				+ "GROUP BY strftime('%Y-%m-%d', CreationDate)";
	}
	public static String calculateTotalCostLastXYearsQuery(int x)
	{
		return "select strftime('%Y', CreationDate), sum(Totalcost) from BuyOrders\r\n"
				+ "where CreationDate BETWEEN date('" + DataConverter.convertDateTimeToString(LocalDateTime.now().minusYears(x)) 
				+  "') AND date('" + DataConverter.convertDateTimeToString(LocalDateTime.now()) + "')\r\n"
				+ "GROUP BY strftime('%Y', CreationDate)";
	}
	public static String calculateTotalCostLastXMonthsQuery(int x)
	{
		return "select strftime('%Y-%m', CreationDate), sum(Totalcost) from BuyOrders\r\n"
				+ "where CreationDate BETWEEN date('" + DataConverter.convertDateTimeToString(LocalDateTime.now().minusMonths(x)) 
				+  "') AND date('" + DataConverter.convertDateTimeToString(LocalDateTime.now()) + "')\r\n"
				+ "GROUP BY strftime('%Y-%m', CreationDate)";
	}
	public static String calculateTotalCostLastXWeeksQuery(int x)
	{
		return "select strftime('%Y-%W', CreationDate), sum(Totalcost) from BuyOrders\r\n"
				+ "where CreationDate BETWEEN date('" + DataConverter.convertDateTimeToString(LocalDateTime.now().minusWeeks(x)) 
				+  "') AND date('" + DataConverter.convertDateTimeToString(LocalDateTime.now()) + "')\r\n"
				+ "GROUP BY strftime('%W', CreationDate)";
	}
	public static String calculateTotalCostLastXDaysQuery(int x)
	{
		return "select strftime('%d-%m-%Y', CreationDate), sum(Totalcost) from BuyOrders\r\n"
				+ "where CreationDate BETWEEN date('" + DataConverter.convertDateTimeToString(LocalDateTime.now().minusDays(x)) 
				+  "') AND date('" + DataConverter.convertDateTimeToString(LocalDateTime.now()) + "')\r\n"
				+ "GROUP BY strftime('%Y-%m-%d', CreationDate)";
	}
	public static void main(String args[]) throws ClassNotFoundException
	{
		//The format below is the SQLite DateTime normal format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DataConverter.getDateTimeFormat());
		
		System.out.println(BusinessQuery.calculateAverageSpendPerOrderFromToQuery(LocalDateTime.MIN, LocalDateTime.now()));
		System.out.println(BusinessQuery.calculateTotalCostLastXWeeksQuery(500));
		System.out.println(BusinessQuery.calculateTotalCostLastXDaysQuery(233));
		System.out.println(BusinessQuery.calculateTotalRevenueLastXDaysQuery(231));
	}
}
