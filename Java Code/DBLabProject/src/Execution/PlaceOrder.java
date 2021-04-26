package Execution;

import java.sql.ResultSet;
import java.sql.SQLException;

import Query.CustomersQuery;
import Query.OrderQuery;

public class PlaceOrder extends Execution {
	//check existence of a phoneNumber within database, return 0 if not, 1,2,3,4... all mean have been at least one
	public static int checkExist(String phoneNumber) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.checkExistQuery(phoneNumber)).getInt(1);
	}
	//return customerID only from the phoneNumber
	public static int getCustomerID(String phoneNumber) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.getCustomerIDQuery(phoneNumber)).getInt(1);
	}
	//insert a customer into the database
	public static void insertCustomer(String address, String phoneNumber, String name, String email) throws SQLException
	{
		statement.executeUpdate(OrderQuery.addCustomerQuery(address, phoneNumber, name, email));
	}
	//insert an order into the database
	public static void insertOrder(int customerID, double totalCost, char status, double discount) throws SQLException
	{
		statement.executeUpdate(OrderQuery.addOrderQuery(customerID, totalCost, status, discount));
	}
	public static double calculateTotalCost(int orderID) throws SQLException
	{
		return statement.executeQuery(OrderQuery.calculateTotalCostQuery(orderID)).getDouble(1);
	}
	public static void removeItemFromOrder(int OrderID, int ProductID) throws SQLException
	{
		statement.executeUpdate(OrderQuery.removeItemFromOrderQuery(OrderID, ProductID));
	}
	public static void addItemToOrder(int ProductID, int OrderID, int quantity) throws SQLException
	{
		OrderQuery.recordItemIntoOrderQuery(OrderID, ProductID, quantity);
	}
	public static ResultSet displayAllItemsInOrder(int OrderID) throws SQLException
	{
		return statement.executeQuery(OrderQuery.displayAllItemsInOrderQuery(OrderID));
	}
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		PlaceOrder.getConnection();
		System.out.println(PlaceOrder.calculateTotalCost(2));
	}

}
