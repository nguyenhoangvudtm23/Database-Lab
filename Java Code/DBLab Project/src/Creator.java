import java.sql.*;
public class Creator {
	public static String createTableIngredientsQuery()
	{
		return "CREATE TABLE \"Ingredients\" (\r\n"
				+ "	\"IngredientID\"	INT,\r\n"
				+ "	\"Name\"	VARCHAR(40),\r\n"
				+ "	\"description\"	VARCHAR(40),\r\n"
				+ "	\"Amount_Left\"	INT,\r\n"
				+ "	PRIMARY KEY(\"IngredientID\")\r\n"
				+ ");";
	}
	public static String createTableProductsQuery()
	{
		
		return "CREATE TABLE \"Products\" (\r\n"
				+ "	\"ProductID\"	INT,\r\n"
				+ "	\"Amount_Left\"	INT,\r\n"
				+ "	\"Selling_Price\"	DOUBLE,\r\n"
				+ "	\"Product_Descript\"	VARCHAR(40),\r\n"
				+ "	PRIMARY KEY(\"ProductID\")\r\n"
				+ ");";
	}
	public static String createTableBuyOrdersQuery()
	{
		return "CREATE TABLE \"BuyOrders\" (\r\n"
				+ "	\"BuyOrderID\"	INT,\r\n"
				+ "	\"SupplierID\"	INT,\r\n"
				+ "	\"TotalCost\"	DOUBLE,\r\n"
				+ "	\"CreationDate\"	DATETIME,\r\n"
				+ "	\"Status\"	VARCHAR(1),\r\n"
				+ "	PRIMARY KEY(\"BuyOrderID\"),\r\n"
				+ "	CONSTRAINT \"check_status_buyorders\" CHECK(\"Status\" = 'C' OR \"Status\" = 'P' OR \"Status\" = 'S' OR \"Status\" = 'F')\r\n"
				+ ");";
	}
	public static String createTableBuyOrderItemsQuery()
	{
		return "CREATE TABLE \"BuyOrderItems\" (\r\n"
				+ "	\"BuyOrderID\"	INT,\r\n"
				+ "	\"IngredientID\"	INT,\r\n"
				+ "	\"Quantity\"	INT,\r\n"
				+ "	\"PricePerUnit\"	DOUBLE,\r\n"
				+ "	CONSTRAINT \"buyorderitems_fk_ingredients\" FOREIGN KEY(\"IngredientID\") REFERENCES \"Ingredients\"(\"IngredientID\") ON DELETE SET NULL,\r\n"
				+ "	CONSTRAINT \"buyorderitems_fk_buyorders\" FOREIGN KEY(\"BuyOrderID\") REFERENCES \"BuyOrders\"(\"BuyOrderID\") ON DELETE SET NULL\r\n"
				+ ");";
	}
	public static String createTableOrdersQuery()
	{
		
		return "CREATE TABLE \"Orders\" (\r\n"
				+ "	\"OrderID\"	INT,\r\n"
				+ "	\"CustomerID\"	INT,\r\n"
				+ "	\"TotalCost\"	DOUBLE,\r\n"
				+ "	\"CreationDate\"	DATETIME,\r\n"
				+ "	\"Status\"	VARCHAR(1),\r\n"
				+ "	\"Discount\"	INT,\r\n"
				+ "	CONSTRAINT \"check_status\" CHECK(\"Status\" = 'C' OR \"Status\" = 'P' OR \"Status\" = 'S' OR \"Status\" = 'F'),\r\n"
				+ "	PRIMARY KEY(\"OrderID\"),\r\n"
				+ "	CONSTRAINT \"orders_fk_customers\" FOREIGN KEY(\"CustomerID\") REFERENCES \"Customers\"(\"CustomerID\") ON DELETE SET NULL\r\n"
				+ ");";
	}
	public static String createTableOrderItemsQuery()
	{

		return "CREATE TABLE \"OrderItems\" (\r\n"
				+ "	\"OrderID\"	INT,\r\n"
				+ "	\"ProductID\"	INT,\r\n"
				+ "	\"Quantity\"	INT,\r\n"
				+ "	\"PricePerUnit\"	DOUBLE,\r\n"
				+ "	CONSTRAINT \"orderitems_fk_orders\" FOREIGN KEY(\"OrderID\") REFERENCES \"Orders\"(\"OrderID\") ON DELETE SET NULL,\r\n"
				+ "	CONSTRAINT \"orderitems_fk_products\" FOREIGN KEY(\"ProductID\") REFERENCES \"Products\"(\"ProductID\") ON DELETE SET NULL\r\n"
				+ ");";
	}
	public static String createTableSuppliersQuery()
	{
		
		return "CREATE TABLE \"Suppliers\" (\r\n"
				+ "	\"SupplierID\"	INT,\r\n"
				+ "	\"Name\"	VARCHAR(40),\r\n"
				+ "	\"Address\"	VARCHAR(40),\r\n"
				+ "	\"Phone_Number\"	VARCHAR(14),\r\n"
				+ "	\"Email\"	VARCHAR(40),\r\n"
				+ "	PRIMARY KEY(\"SupplierID\")\r\n"
				+ ");";
	}
	public static String createTableCustomersQuery()
	{
		
		return "CREATE TABLE \"Customers\" (\r\n"
				+ "	\"CustomerID\"	INT,\r\n"
				+ "	\"Address\"	VARCHAR(40),\r\n"
				+ "	\"Phone_Number\"	VARCHAR(14) UNIQUE,\r\n"
				+ "	\"Name\"	VARCHAR(40),\r\n"
				+ "	\"Email\"	VARCHAR(40),\r\n"
				+ "	PRIMARY KEY(\"CustomerID\")\r\n"
				+ ");";
	}
	public static String createTableIngreListQuery()
	{
		return "CREATE TABLE \"IngreList\" (\r\n"
				+ "	\"ProductID\"	INT,\r\n"
				+ "	\"IngredientID\"	INT,\r\n"
				+ "	\"Quantity\"	INT,\r\n"
				+ "	CONSTRAINT \"ingrelist_fk_ingredients\" FOREIGN KEY(\"IngredientID\") REFERENCES \"Ingredients\"(\"IngredientID\") ON DELETE SET NULL,\r\n"
				+ "	CONSTRAINT \"ingrelist_fk_products\" FOREIGN KEY(\"ProductID\") REFERENCES \"Products\"(\"ProductID\") ON DELETE SET NULL\r\n"
				+ ");";
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
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
