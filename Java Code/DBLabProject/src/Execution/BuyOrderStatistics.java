package Execution;

import java.sql.ResultSet;
import java.sql.SQLException;

import Query.BuyOrderQuery;

public class BuyOrderStatistics extends Execution{
	public static void updateBuyOrdersSupplierIDQuery(int BuyOrderID, int newSupplierID) throws SQLException
	{
		statement.executeUpdate(BuyOrderQuery.updateBuyOrdersSupplierIDQuery(BuyOrderID, newSupplierID));
	}
	public static void updateBuyOrdersStatusQuery(int BuyOrderID, char newStatus) throws SQLException
	{
		statement.executeUpdate(BuyOrderQuery.updateBuyOrdersStatusQuery(BuyOrderID, newStatus));
	}
	public static void updateBuyOrderItemsQuantityQuery(int BuyOrderID, int IngredientID, int newQuantity) throws SQLException
	{
		statement.executeUpdate(BuyOrderQuery.updateBuyOrderItemsQuantityQuery(BuyOrderID, IngredientID, newQuantity));
	}
	public static void updateBuyOrderItemsPricePerUnitQuery(int BuyOrderID, int IngredientID, double newPricePerUnit) throws SQLException
	{
		statement.executeUpdate(BuyOrderQuery.updateBuyOrderItemsPricePerUnitQuery(BuyOrderID, IngredientID, newPricePerUnit));
	}
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
	public static ResultSet selectAllBuyOrders() throws SQLException
	{
		return statement.executeQuery(BuyOrderQuery.selectAllBuyOrdersQuery());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
