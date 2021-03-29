package Execution;

import java.sql.ResultSet;
import java.sql.SQLException;

import Query.CustomersQuery;
import Query.OrderQuery;

public class PlaceOrder extends Execution {
	public static String checkExist(String phoneNumber) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.checkExistQuery(phoneNumber)).getString(1);
	}
	public static String getCustomerID(String phoneNumber) throws SQLException
	{
		return statement.executeQuery(CustomersQuery.getCustomerIDQuery(phoneNumber)).getString(1);
	}
	public static void insertCustomer(String address, String phoneNumber, String name, String email) throws SQLException
	{
		statement.executeUpdate(OrderQuery.addCustomerQuery(address, phoneNumber, name, email));
	}
	public static void insertOrder(int customerID, double totalCost, char status, double discount) throws SQLException
	{
		statement.executeUpdate(OrderQuery.addOrderQuery(customerID, totalCost, status, discount));
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		PlaceOrder.getConnection();
		PlaceOrder.insertCustomer("30 Nui Truc", "0192433231", "Harold", "harold@gmail.com");
	}

}
