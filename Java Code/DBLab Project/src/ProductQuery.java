import java.sql.*;
import java.time.LocalDateTime;
public class ProductQuery {
	public static String calculateOneProductRevenueFromToQuery(int ID, LocalDateTime from, LocalDateTime to)
	{
		return "SELECT SUM(OI.PricePerUnit*OI.Quantity) \r\n"
				+ "FROM OrderItems as OI\r\n"
				+ "JOIN Orders AS O \r\n"
				+ "WHERE (O.CreationDate BETWEEN " + "'" 
				+ DataConverter.TimeToString(from) +"' AND '" 
				+ DataConverter.TimeToString(to) + "')\n"		
				+ "AND (OI.ProductID = " + Integer.toString(ID) +  ")" 							
				+ "";
	}
	public static String calculateAllProductRevenueFromToQuery(LocalDateTime from, LocalDateTime to)
	{
		return "SELECT OI.ProductID, SUM(OI.PricePerUnit*OI.Quantity) AS Total\r\n"
				+ "FROM OrderItems as OI\r\n"
				+ "JOIN Orders AS O \r\n"
				+ "WHERE (O.CreationDate BETWEEN '"
				+ DataConverter.TimeToString(from) + "' AND '"
				+ DataConverter.TimeToString(to) + "') \n"
				+ "GROUP BY OI.ProductID"
				+ "ORDER BY Total DESC";
	}
	public static String calculateOneIngredientCostFromToQuery(int ID, LocalDateTime from, LocalDateTime to)
	{
		return "";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ProductQuery.calculateAllProductRevenueFromToQuery(LocalDateTime.MIN, LocalDateTime.now()));
	}

}
