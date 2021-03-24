import java.sql.*;
public class Tester {
	
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
		statement.executeUpdate(Creator.createTableCustomersQuery());
		
		//SUPPLIERS
		statement.executeUpdate("DROP TABLE IF EXISTS Suppliers");
		statement.executeUpdate(Creator.createTableSuppliersQuery());
		
		//INGREDIENTS
		statement.executeUpdate("DROP TABLE IF EXISTS Ingredients");
		statement.executeUpdate(Creator.createTableIngredientsQuery());
		
		//PRODUCTS
		statement.executeUpdate("DROP TABLE IF EXISTS Products");
		statement.executeUpdate(Creator.createTableProductsQuery());
		
		//BUYORDERS
		statement.executeUpdate("DROP TABLE IF EXISTS BuyOrders");
		statement.executeUpdate(Creator.createTableBuyOrdersQuery());
		
		//BUYORDERSITEMS
		statement.executeUpdate("DROP TABLE IF EXISTS BuyOrderItems");
		statement.executeUpdate(Creator.createTableBuyOrderItemsQuery());
		
		//ORDERS
		statement.executeUpdate("DROP TABLE IF EXISTS Orders");
		statement.executeUpdate(Creator.createTableOrdersQuery());
				
		//ORDERITEMS
		statement.executeUpdate("DROP TABLE IF EXISTS OrderItems");
		statement.executeUpdate(Creator.createTableOrderItemsQuery());
		
		//INGRELIST
		statement.executeUpdate("DROP TABLE IF EXISTS IngreList");
		statement.executeUpdate(Creator.createTableIngreListQuery());
		
		//For testing purpose only
		
		statement.executeUpdate("INSERT INTO Customers values(1, '1', 'Vu','Hai','m')");
		ResultSet set = statement.executeQuery("SELECT * FROM Customers");
		while (set.next())
		{
			System.out.println("ID: " + Integer.parseInt(set.getString("CustomerID")));
			System.out.println("Name: " + set.getString("Name"));
		}
	}

}
