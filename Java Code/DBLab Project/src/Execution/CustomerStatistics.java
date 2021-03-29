package Execution;

import java.sql.ResultSet;
import java.sql.SQLException;

import Query.CustomersQuery;

public class CustomerStatistics extends Execution{
	//return 2 columns customerID + Total spending
	public static ResultSet sortByTotalDesc(int limit) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.sortByTotalDescQuery(limit));
	}
	public static void main(String args[])
	{
		
	}
}
