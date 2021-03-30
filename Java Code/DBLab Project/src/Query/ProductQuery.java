package Query;

import java.time.LocalDateTime;
public class ProductQuery {
	public static String calculateOneProductRevenueFromToQuery(int ID, LocalDateTime from, LocalDateTime to)
	{
		return "SELECT SUM(OI.PricePerUnit*OI.Quantity) \r\n"
				+ "FROM OrderItems as OI\r\n"
				+ "JOIN Orders AS O ON (OI.OrderID = O.OrderID)\r\n"
				+ "WHERE (O.CreationDate BETWEEN " + "'" 
				+ DataConverter.convertDateTimeToString(from) +"' AND '" 
				+ DataConverter.convertDateTimeToString(to) + "')\n"		
				+ "AND (OI.ProductID = " + Integer.toString(ID) +  ")" 							
				;
	}
	public static String getProductNameQuery(int ID)
	{
		return "select Product_Descript from Products\r\n"
				+ "where ProductID = " + ID;
	}
	public static String calculateAllProductRevenueFromToQuery(LocalDateTime from, LocalDateTime to)
	{
		return "SELECT OI.ProductID, SUM(OI.PricePerUnit*OI.Quantity) AS Total\r\n"
				+ "FROM OrderItems as OI\r\n"
				+ "JOIN Orders AS O ON (OI.OrderID = O.OrderID)\r\n"
				+ "WHERE (O.CreationDate BETWEEN '"
				+ DataConverter.convertDateTimeToString(from) + "' AND '"
				+ DataConverter.convertDateTimeToString(to) + "') \n"
				+ "GROUP BY OI.ProductID \n"
				+ "ORDER BY Total DESC";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ProductQuery.getProductNameQuery(23));
	}

}
