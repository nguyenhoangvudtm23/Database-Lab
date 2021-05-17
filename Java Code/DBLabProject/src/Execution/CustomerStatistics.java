package Execution;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import Query.CustomersQuery;
import Scenario.Starter;

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
	//return all Customers who have similar name to a given pattern
	public static ResultSet getCustomersWhoHaveSimilarNameTo(String name) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.getCustomersWhoHaveSimilarNameToQuery(name));
	}
	//update Customer's Name
	public static void updateCustomerName(int ID, String newName) throws SQLException
	{
		statement.executeQuery(CustomersQuery.updateCustomerNameQuery(ID, newName));
	}
	//update Customer's Email
	public static void updateCustomerEmail(int ID, String newEmail) throws SQLException
	{
		statement.executeQuery(CustomersQuery.updateCustomerEmailQuery(ID, newEmail));
	}
	//update Customer's Address
	public static void updateCustomerAddress(int ID, String newAddress) throws SQLException
	{
		statement.executeQuery(CustomersQuery.updateCustomerAddressQuery(ID, newAddress));
	}
	//update Customer's phone number
	public static void updateCustomerPhoneNumber(int ID, String phoneNumber) throws SQLException
	{
		if (checkExist(phoneNumber) == 0)
		{
			statement.executeQuery(CustomersQuery.updateCustomerPhoneNumberQuery(ID, phoneNumber));
		}
	}
	public static int checkExist(String phoneNumber) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.checkExistQuery(phoneNumber)).getInt(1);
	}
	//return top spending Customer during a period of time only
	public static ResultSet getTopXSpendCustomersFromTo(int X, LocalDateTime from, LocalDateTime to) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.getTopXSpendCustomersFromToQuery(X, from, to));
	}
	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		Starter.starting();
		ResultSet set = CustomerStatistics.getCustomersWhoHaveSimilarNameTo("Hai");
		while (set.next())
		{
			System.out.println(set.getString(4));
		}
	}
}
