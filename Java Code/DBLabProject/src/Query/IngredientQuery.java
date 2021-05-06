package Query;

import java.time.LocalDateTime;

public class IngredientQuery {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(IngredientQuery.getIngredientsWithSimilarNameQuery("beef"));
	}

}
