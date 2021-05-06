package Execution;

import java.sql.ResultSet;
import java.sql.SQLException;

import Query.BuyOrderQuery;

public class BuyOrderStatistics extends Execution{
	public static double calculateTotalCost(int BuyOrderID) throws SQLException
	{
		return statement.executeQuery(BuyOrderQuery.calculateTotalCostQuery(BuyOrderID)).getDouble(1);
	}
	public static ResultSet showBuyOrderItemsQuery(int BuyOrderID) throws SQLException
	{
		return statement.executeQuery(BuyOrderQuery.showBuyOrderItemsQuery(BuyOrderID));
	}
	public static void deleteBuyOrderQuery(int BuyOrderID) throws SQLException
	{
		statement.executeUpdate(BuyOrderQuery.deleteBuyOrderQuery(BuyOrderID));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
