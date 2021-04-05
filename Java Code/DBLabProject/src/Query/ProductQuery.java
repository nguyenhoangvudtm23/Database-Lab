package Query;

import java.time.LocalDateTime;
public class ProductQuery {
	
	public static String updatePriceQuery(int ProductID, double newPrice)
	{
		return "update Products \r\n"
				+ "SET Selling_Price = " + newPrice +"\r\n"
				+ "WHERE ProductID = " + ProductID;
	}
	public static String updateNameQuery(int ProductID, String newName)
	{
		return "update Products \r\n"
				+ "SET Product_Descript = \"" + newName + "\"\r\n"
				+ "WHERE ProductID = " + ProductID;
	}
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
	public static String getProductPriceQuery(int ID)
	{
		return "select Selling_Price FROM Products\r\n"
				+ "where ProductID = " + ID;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ProductQuery.updateNameQuery(2, "kaka"));
	}

}
