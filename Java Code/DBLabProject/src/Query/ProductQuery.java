package Query;

import java.time.LocalDateTime;
public class ProductQuery {
	public static String selectAllQuery()
	{
		return "select Product_Descript, Amount_Left, Selling_Price, ProductID from Products";
	}
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
	public static String updateAmountLeftQuery(int ProductID, int newAmountLeft)
	{
		return "update Products \r\n"
				+ "SET Amount_Left = \"" + newAmountLeft + "\"\r\n"
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
	public static String getProductsWithSimilarNameQuery(String pattern)
	{
		return "select * from Products WHERE\r\n"
				+ "Product_Descript LIKE '%" + pattern +  "%'";
	}
	public static String getTopXSellingProductsFromToQuery(int X, LocalDateTime from, LocalDateTime to)
	{
		return "select Products.Product_Descript, sum(Quantity) as Sold\r\n"
				+ "from OrderItems join Products on OrderItems.ProductID = Products.ProductID\r\n"
				+ "where OrderID in(\r\n"
				+ "	select OrderID\r\n"
				+ "	from Orders \r\n"
				+ "where CreationDate between '"
				+ DataConverter.convertDateTimeToString(from) + "' and '"
				+ DataConverter.convertDateTimeToString(to) + "')\r\n"
				+ "group by Products.ProductID\n"
				+ "order by Sold desc\n"
				+ "limit " + X;
	}
	public static String getLeastXSellingProductsFromToQuery(int X, LocalDateTime from, LocalDateTime to)
	{
		return "select Products.Product_Descript, sum(Quantity) as Sold\r\n"
				+ "from OrderItems join Products on OrderItems.ProductID = Products.ProductID\r\n"
				+ "where OrderID in(\r\n"
				+ "	select OrderID\r\n"
				+ "	from Orders \r\n"
				+ "where CreationDate between '"
				+ DataConverter.convertDateTimeToString(from) + "' and '"
				+ DataConverter.convertDateTimeToString(to) + "')\r\n"
				+ "group by Products.ProductID\n"
				+ "order by Sold asc\n"
				+ "limit " + X;
	}
	public static String insertProductQuery(String name, double Price, int amount_left)
	{
		return "insert into Products\r\n"
				+ "(Product_Descript, Amount_Left, Selling_Price)\r\n"
				+ "values ('" + name + "', " + amount_left +  ", " +  Price + ")";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ProductQuery.getProductsWithSimilarNameQuery("beef"));
		System.out.println();
		System.out.println(ProductQuery.getLeastXSellingProductsFromToQuery(0, LocalDateTime.MIN, LocalDateTime.MAX));
		System.out.println();
		System.out.println(ProductQuery.getTopXSellingProductsFromToQuery(0, LocalDateTime.MIN, LocalDateTime.MAX));
		System.out.println();
		System.out.println(ProductQuery.insertProductQuery("cala", 1200000, 5));
	}

}
