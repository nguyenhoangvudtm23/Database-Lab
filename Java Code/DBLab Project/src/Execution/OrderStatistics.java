package Execution;

import java.sql.ResultSet;
import java.sql.SQLException;

import Query.OrderQuery;

public class OrderStatistics extends Execution{
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
