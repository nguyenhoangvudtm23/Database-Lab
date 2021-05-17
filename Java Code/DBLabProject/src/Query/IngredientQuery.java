package Query;

import java.time.LocalDateTime;

public class IngredientQuery {
	public static String insertIngredientQuery(String name, String description, double price, int amountleft)
	{
		return "insert into Ingredients (Name, description, Amount_Left, PricePerUnit) "
				+ "VALUES ('" + name + "', '" + description + "', " + amountleft + ", " + price + ")";
	}
	public static String getAllIngredientQuery()
	{
		return "select Name, description, Amount_Left, PricePerUnit from Ingredients";
	}
	public static String calculateOneIngredientCostFromToQuery(int ID, LocalDateTime from, LocalDateTime to)
	{
		return "SELECT SUM(OI.PricePerUnit*OI.Quantity) \r\n"
				+ "FROM BuyOrderItems as OI\r\n"
				+ "JOIN BuyOrders AS O ON (OI.BuyOrderID = O.BuyOrderID)\r\n"
				+ "WHERE (O.CreationDate BETWEEN '"
				+ DataConverter.convertDateTimeToString(from) + "' AND '"
				+ DataConverter.convertDateTimeToString(to) + "') \n"
				+ "AND (OI.IngredientID = " + Integer.toString(ID)+ ") ";
	}
	public static String calculateAllIngredientCostFromToQuery(LocalDateTime from, LocalDateTime to)
	{
		return "select sum(Totalcost) from BuyOrders\r\n"
				+ "where CreationDate BETWEEN '" 
				+ DataConverter.convertDateTimeToString(from) +"' "
				+ "and '"
				+ DataConverter.convertDateTimeToString(to) + "'";
	}
	public static String getIngredientNameQuery(int ID)
	{
		return "select Name from Ingredients\r\n"
				+ "where IngredientID = " + ID;
	}
	public static String updateIngredientNameQuery(int ID, String newName)
	{
		return "update Ingredients\r\n"
				+ "set Name = '" + newName + "'\r\n"
				+ "where IngredientID = " + ID;
	}
	public static String getIngredientsWithSimilarNameQuery(String pattern)
	{
		return "select * from Ingredients WHERE\r\n"
				+ "Name LIKE '%" + pattern +"%'\r\n"
				+ "";
	}
	public static String updateIngreListQuantityQuery(int ProductID, int IngredientID, int newQuantity)
	{
		return "update IngreList\r\n"
				+ "set Quantity = '" + newQuantity + "'\r\n"
				+ "where ProductID = " + ProductID + " and IngredientID = " + IngredientID;
	}
	public static String updateIngredientdescriptionQuery(int IngredientID, String newdescription)
	{
		return "update Ingredients\r\n"
				+ "set description = '" + newdescription + "'\r\n"
				+ "where IngredientID = " + IngredientID;
	}
	public static String topXmostcostingredientsYdaysQuery(int x, int y)
	{
		return "SELECT Ingredients.IngredientID, Name, sum(BuyOrderItems.PricePerUnit*Quantity) as totalcost from BuyOrderItems, Ingredients\r\n"
				+ "WHERE BuyOrderItems.IngredientID=Ingredients.IngredientID\r\n"
				+ "AND CreationDate BETWEEN date('" + DataConverter.convertDateTimeToString(LocalDateTime.now().minusDays(y))
				+  "') AND date('" + DataConverter.convertDateTimeToString(LocalDateTime.now()) + "')\r\n"
				+ "GROUP BY Ingredients.IngredientID ORDER BY totalcost DESC LIMIT "+x;
	}
	public static String topXmostcostingredientsYmonthsQuery(int x, int y)
	{
		return "SELECT Ingredients.IngredientID, Name, sum(BuyOrderItems.PricePerUnit*Quantity) as totalcost from BuyOrderItems, Ingredients\r\n"
				+ "WHERE BuyOrderItems.IngredientID=Ingredients.IngredientID\r\n"
				+ "AND CreationDate BETWEEN date('" + DataConverter.convertDateTimeToString(LocalDateTime.now().minusMonths(y))
				+  "') AND date('" + DataConverter.convertDateTimeToString(LocalDateTime.now()) + "')\r\n"
				+ "GROUP BY Ingredients.IngredientID ORDER BY totalcost DESC LIMIT "+x;
	}
	public static String topXmostcostingredientsYyearsQuery(int x, int y)
	{
		return "SELECT Ingredients.IngredientID, Name, sum(BuyOrderItems.PricePerUnit*Quantity) as totalcost from BuyOrderItems, Ingredients\r\n"
				+ "WHERE BuyOrderItems.IngredientID=Ingredients.IngredientID\r\n"
				+ "AND CreationDate BETWEEN date('" + DataConverter.convertDateTimeToString(LocalDateTime.now().minusYears(y))
				+  "') AND date('" + DataConverter.convertDateTimeToString(LocalDateTime.now()) + "')\r\n"
				+ "GROUP BY Ingredients.IngredientID ORDER BY totalcost DESC LIMIT "+x;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(IngredientQuery.getIngredientsWithSimilarNameQuery("beef"));
		System.out.println(IngredientQuery.insertIngredientQuery("hola", "sda", 5, 5));
	}

}