package Query;

public class CustomersQuery {
	public static String checkExistQuery(String phoneNumber)
	{
		return "select count(*) from Customers\r\n"
				+ "where Phone_Number = " + "'" + phoneNumber + "'";
	}
	public static String sortByTotalDescQuery(int limit)
	{
		return "SELECT C.CustomerID, SUM(O.TotalCost) AS Total\r\n"
				+ "FROM Customers C JOIN Orders O\r\n"
				+ "ON C.CustomerID = O.CustomerID\r\n"
				+ "GROUP BY C.CustomerID\r\n"
				+ "ORDER BY Total DESC\r\n"
				+ "LIMIT " + Integer.toString(limit);
	}
	public static String getOneCustomerTotalSpendQuery(int ID)
	{
		return "SELECT SUM(O.TotalCost) AS Total\r\n"
				+ "FROM Orders O\r\n"
				+ "WHERE CustomerID = " + Integer.toString(ID);
	}
	public static String getCustomerNameQuery(String phoneNumber)
	{
		return "SELECT Name FROM Customers\r\n"
				+ "WHERE Phone_Number = '" + phoneNumber + "'";
	}
	public static String getCustomerIDQuery(String phoneNumber)
	{
		return "select CustomerID\r\n"
				+ "from Customers where Phone_Number = '" + phoneNumber + "'";
	}
	public static void main(String args[]) throws ClassNotFoundException
	{
		System.out.println(CustomersQuery.getCustomerIDQuery("0329859743"));
	}
}
