package Query;

import java.time.LocalDateTime;

public class CustomersQuery {
	public static String checkExistQuery(String phoneNumber)
	{
		return "select count(*) from Customers\r\n"
				+ "where Phone_Number = " + "'" + phoneNumber + "'";
	}
	public static String sortAllCustomersByTotalSpendDescQuery(int limit)
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
	public static String getCustomersWhoHaveSimilarNameToQuery(String name)
	{
		return "select * from customers\r\n"
				+ "where Name like \"%" + name + "%\"";
	}
	public static String getCustomerNameQuery(int ID)
	{
		return "SELECT Name FROM Customers\r\n"
				+ "WHERE CustomerID = " + ID ;
	}
	public static String getCustomerIDQuery(String phoneNumber)
	{
		return "select CustomerID\r\n"
				+ "from Customers where Phone_Number = '" + phoneNumber + "'";
	}
	public static String getOneCustomerTotalSpendFromToQuery(int ID, LocalDateTime from, LocalDateTime to)
	{
		return "select sum(Totalcost) from Orders\r\n"
				+ "where (CustomerID = " + ID + ") AND (CreationDate between '"
						+ DataConverter.convertDateTimeToString(from) + "' and '"
						+ DataConverter.convertDateTimeToString(to) + "')";
	}
	public static String updateCustomerNameQuery(int CustomerID, String newName)
	{
		return "update Customers\r\n"
				+ "set Name = '" + newName + "'\r\n"
				+ "where CustomerID = " + CustomerID;
	}
	public static String updateCustomerPhoneNumberQuery(int CustomerID, String phoneNumber)
	{
		return "update Customers\r\n"
				+ "set Phone_Number = '" + phoneNumber + "'\r\n"
				+ "where CustomerID = " + CustomerID;
	}
	public static void main(String args[]) throws ClassNotFoundException
	{
		System.out.println(CustomersQuery.updateCustomerPhoneNumberQuery(1, "0123584321"));
	}
}
