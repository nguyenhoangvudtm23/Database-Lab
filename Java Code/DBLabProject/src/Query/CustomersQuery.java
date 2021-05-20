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
	public static String updateCustomerAddressQuery(int CustomerID, String newAddress)
	{
		return "update Customers\r\n"
				+ "set Address = '" + newAddress + "'\r\n"
				+ "where CustomerID = " + CustomerID;
	}
	public static String updateCustomerEmailQuery(int CustomerID, String newEmail)
	{
		return "update Customers\r\n"
				+ "set Email = '" + newEmail + "'\r\n"
				+ "where CustomerID = " + CustomerID;
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
	public static String getTopXSpendCustomersFromToQuery(int X, LocalDateTime from, LocalDateTime to)
	{
		return "select Customers.Name || ' (' ||Customers.Phone_Number||')' AS INFO, sum(Totalcost - Discount) as Pay\r\n"
				+ "from Orders join Customers on  Orders.CustomerID = Customers.CustomerID\r\n"
				+ "where CreationDate between '"
				+ DataConverter.convertDateTimeToString(from) + "' and '"
				+ DataConverter.convertDateTimeToString(to) + "'\r\n"
				+ "group by Customers.CustomerID\r\n"
				+ "order by Pay desc\r\n"
				+ "limit " + X;
	}
	public static String getAllCustomerQuery()
	{
		return "select Name, Phone_Number, Address, Email\r\n"
				+ "from Customers";
	}
	public static String insertCustomerQuery(String address, String phoneNumber, String name, String email)
	{
		return "insert into Customers (Address, Phone_Number, Name, Email) VALUES " 
				+ "('" + address + "', '" + phoneNumber + "', '" + name + "', '" + email + "')";
	}
	public static void main(String args[]) throws ClassNotFoundException
	{
		System.out.println(CustomersQuery.updateCustomerPhoneNumberQuery(1, "0123584321"));
		System.out.println();
		System.out.println(CustomersQuery.getTopXSpendCustomersFromToQuery(0, LocalDateTime.MIN, LocalDateTime.MAX));
		System.out.println();
		System.out.println(CustomersQuery.insertCustomerQuery("ale", "0123", "asd", "sdf"));
	}
}
