
public class CustomersQuery {
	public static String sortByTotalDescQuery(int limit)
	{
		return "SELECT C.CustomerID, SUM(O.TotalCost) AS Total\r\n"
				+ "FROM Customers C JOIN Orders O\r\n"
				+ "ON C.CustomerID = O.CustomerID\r\n"
				+ "GROUP BY C.CustomerID\r\n"
				+ "ORDER BY Total DESC\r\n"
				+ "LIMIT " + Integer.toString(limit);
	}
	public static String customerTotalSpendQuery(int ID)
	{
		return "SELECT SUM(O.TotalCost) AS Total\r\n"
				+ "FROM Orders O\r\n"
				+ "WHERE CustomerID = " + Integer.toString(ID);
	}
	
	public static void main(String args[]) throws ClassNotFoundException
	{
	
	}
}
