package Execution;

import java.sql.ResultSet;
import java.sql.SQLException;

import Query.CustomersQuery;
import Scenario.Tester;

public class CustomerStatistics extends Execution{
	//return 2 columns customerID + Total spending
	public static ResultSet sortByTotalDesc(int limit) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.sortByTotalDescQuery(limit));
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
	public static double getOneCustomerTotalSpend(int ID) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.getOneCustomerTotalSpendQuery(ID)).getDouble(1);
	}
	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		Tester.starting();
	}
}
