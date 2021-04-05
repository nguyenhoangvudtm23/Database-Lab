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
		ResultSet set = statement.executeQuery(OrderQuery.showOrderItemsQuery(orderID));
		double ans = 0;
		while (set.next())
		{
			//2 is Quantity, 4 is SellingPrice
			ans = ans + set.getDouble(2) * set.getDouble(4);
		}
		return ans;
	}
	public static void addItemToOrder(int ProductID, int OrderID, int quantity) throws SQLException
	{
		double PricePerUnit = ProductStatistics.getProductPrice(ProductID);
		OrderQuery.recordItemIntoOrderQuery(OrderID, ProductID, quantity, PricePerUnit);
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		PlaceOrder.getConnection();
		System.out.println(PlaceOrder.calculateTotalCost(2));
	}

}
