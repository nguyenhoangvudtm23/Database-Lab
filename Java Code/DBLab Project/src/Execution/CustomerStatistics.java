package Execution;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import Query.CustomersQuery;
import Scenario.Tester;

public class CustomerStatistics extends Execution{
	/**CUSTOMERS TABLE HAS THE FOLLOWING COLUMNS
	1 is CustomerID
	2 is Address
	3 is Phone_Number
	4 is Name
	5 is Email
	**/
	//return 2 columns customerID + Total spending
	public static ResultSet sortAllCustomersByTotalSpendDesc(int limit) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.sortAllCustomersByTotalSpendDescQuery(limit));
	}
	//return customerID only
	public static int getCustomerID(String phoneNumber) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.getCustomerIDQuery(phoneNumber)).getInt(1);
	}
	//return customerName only
	public static String getCustomerName(String phoneNumber) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.getCustomerNameQuery(phoneNumber)).getString(1);
	}
	public static String getCustomerName(int ID) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.getCustomerNameQuery(ID)).getString(1);
	}
	//return Customer's Total Spend since the db created only
	public static double getOneCustomerTotalSpend(int ID) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.getOneCustomerTotalSpendQuery(ID)).getDouble(1);
	}
	//return Customer's Total Spend during a period of time only
	public static double getOneCustomerTotalSpendFromTo(int ID, LocalDateTime from, LocalDateTime to) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.getOneCustomerTotalSpendFromToQuery(ID, from, to)).getDouble(1);
	}
	//return all Customers who has similar name to a given pattern
	public static ResultSet getCustomersWhoHaveSimilarNameTo(String name) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.getCustomersWhoHaveSimilarNameToQuery(name));
	}
	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		Tester.starting();
		ResultSet set = CustomerStatistics.getCustomersWhoHaveSimilarNameTo("Hai");
		while (set.next())
		{
			System.out.println(set.getString(4));
		}
	}
}
