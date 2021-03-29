package Execution;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import Query.ProductQuery;

public class ProductStatistics extends Execution {
	//return total revenue of 1 product during a period of time only
	public static double calculateOneProductRevenueFromTo(int ProductID, LocalDateTime from, LocalDateTime to) throws SQLException
	{
		return statement.executeQuery(ProductQuery.calculateOneProductRevenueFromToQuery(ProductID, from, to)).getDouble(1);
	}
	//return 2 columns - ProductID and its total revenue during a period of time
	public static ResultSet calculateAllProductRevenueFromTo(LocalDateTime from, LocalDateTime to) throws SQLException
	{
		return statement.executeQuery(ProductQuery.calculateAllProductRevenueFromToQuery(from, to));
	}
	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		ProductStatistics.getConnection();
		ResultSet set = ProductStatistics.calculateAllProductRevenueFromTo(LocalDateTime.MIN, LocalDateTime.now());
		while (set.next())
		{
			System.out.println("ID: " + set.getString(1) + "\tRevenue: " + set.getDouble(2));
		}
	}
}
