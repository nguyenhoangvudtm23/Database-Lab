import java.sql.*;
public class Destructor {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("org.sqlite.JDBC");
		
		Connection connection = DriverManager.getConnection("jdbc:sqlite:creation.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(23);
	
		statement.setQueryTimeout(45);
		//need to drop if exists
		
		//CUSTOMERS
		statement.executeUpdate("DROP TABLE IF EXISTS Customers");
		
		//SUPPLIERS
		statement.executeUpdate("DROP TABLE IF EXISTS Suppliers");
		
		//INGREDIENTS
		statement.executeUpdate("DROP TABLE IF EXISTS Ingredients");
		
		//PRODUCTS
		statement.executeUpdate("DROP TABLE IF EXISTS Products");
		
		//BUYORDERS
		statement.executeUpdate("DROP TABLE IF EXISTS BuyOrders");
		
		//BUYORDERSITEMS
		statement.executeUpdate("DROP TABLE IF EXISTS BuyOrderItems");
		
		//ORDERS
		statement.executeUpdate("DROP TABLE IF EXISTS Orders");

		//ORDERITEMS
		statement.executeUpdate("DROP TABLE IF EXISTS OrderItems");

		//INGRELIST
		statement.executeUpdate("DROP TABLE IF EXISTS IngreList");

	}

}
