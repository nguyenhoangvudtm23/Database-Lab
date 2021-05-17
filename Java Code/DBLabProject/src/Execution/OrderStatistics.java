package Execution;

import java.sql.ResultSet;
import java.sql.SQLException;

import Query.OrderQuery;

public class OrderStatistics extends Execution{
	public static void updateOrderItemsQuantityQuery(int OrderID, int ProductID, int newQuantity) throws SQLException
	{
		statement.executeUpdate(OrderQuery.updateOrderItemsQuantityQuery(OrderID, ProductID, newQuantity));
	}
	public static void updateOrdersStatusQuery(int OrderID, char newStatus) throws SQLException
	{
		statement.executeUpdate(OrderQuery.updateOrdersStatusQuery(OrderID, newStatus));
	}
	public static void updateOrdersDiscountQuery(int OrderID, int newDiscount) throws SQLException
	{
		statement.executeUpdate(OrderQuery.updateOrdersDiscountQuery(OrderID, newDiscount));
	}
	//delete Order with given ID
	public static void deleteOrder(int ID) throws SQLException
	{
		statement.executeUpdate(OrderQuery.deleteOrderQuery(ID));
	}
	//show ProductID, Quantity and ProductName
	public static ResultSet showOrderItems(int ID) throws SQLException
	{
		return statement.executeQuery(OrderQuery.showOrderItemsQuery(ID));
	}
	public static double calculateTotalCost(int orderID) throws SQLException
	{
		return statement.executeQuery(OrderQuery.calculateTotalCostQuery(orderID)).getDouble(1);
	}
	public static ResultSet displayAllItemsInOrder(int OrderID) throws SQLException
	{
		return statement.executeQuery(OrderQuery.displayAllItemsInOrderQuery(OrderID));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
