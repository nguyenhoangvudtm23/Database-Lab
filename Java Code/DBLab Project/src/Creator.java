import java.sql.*;
public class Creator {
	public String CreateTableIngredients()
	{
		StringBuilder string = new StringBuilder();
		string.append("CREATE TABLE \"Ingredients\" (\r\n"
				+ "	\"IngredientID\"	INTEGER,\r\n"
				+ "	\"Name\"	TEXT NOT NULL,\r\n"
				+ "	\"Description\"	TEXT NOT NULL,\r\n"
				+ "	\"AmountLeft\"	INTEGER NOT NULL DEFAULT 0,\r\n"
				+ "	PRIMARY KEY(\"IngredientID\" AUTOINCREMENT)\r\n"
				+ ");");
		return string.toString();
	}
	public String CreateTableProducts()
	{
		StringBuilder string = new StringBuilder();
		string.append("CREATE TABLE \"Products\" (\r\n"
				+ "	\"ProductID\"	INTEGER,\r\n"
				+ "	\"Amount_Left\"	INTEGER NOT NULL DEFAULT 0,\r\n"
				+ "	\"SellingPrice\"	REAL NOT NULL DEFAULT 0,\r\n"
				+ "	\"Description\"	TEXT NOT NULL,\r\n"
				+ "	\"ProductName\"	TEXT NOT NULL,\r\n"
				+ "	PRIMARY KEY(\"ProductID\" AUTOINCREMENT)\r\n"
				+ ");");
		return string.toString();
	}
	public String CreateTableBuyOrders()
	{
		StringBuilder string = new StringBuilder();
		string.append("CREATE TABLE \"BuyOrders\" (\r\n"
				+ "	\"BuyOrderID\"	INTEGER,\r\n"
				+ "	\"SupplierID\"	INTEGER,\r\n"
				+ "	\"Status\"	INTEGER NOT NULL DEFAULT 0,\r\n"
				+ "	\"CreationDate\"	datetime DEFAULT current_timestamp,\r\n"
				+ "	\"TotalCost\"	REAL DEFAULT 0,\r\n"
				+ "	PRIMARY KEY(\"BuyOrderID\" AUTOINCREMENT),\r\n"
				+ "	FOREIGN KEY(\"SupplierID\") REFERENCES \"Suppliers\"(\"SupplierID\")\r\n"
				+ ");");
		return string.toString();
	}
	public String CreateTableBuyOrderItems()
	{
		StringBuilder string = new StringBuilder();
		string.append("CREATE TABLE \"BuyOrderItems\" (\r\n"
				+ "	\"BuyOrderID\"	INTEGER,\r\n"
				+ "	\"IngredientID\"	INTEGER,\r\n"
				+ "	\"Quantity\"	INTEGER NOT NULL DEFAULT 0,\r\n"
				+ "	\"PricePerUnit\"	REAL DEFAULT 0,\r\n"
				+ "	FOREIGN KEY(\"BuyOrderID\") REFERENCES \"BuyOrders\"(\"BuyOrderID\"),\r\n"
				+ "	FOREIGN KEY(\"IngredientID\") REFERENCES \"Ingredients\"(\"IngredientID\")\r\n"
				+ ");");
		return string.toString();
	}
	public String CreateTableOrders()
	{
		StringBuilder string = new StringBuilder();
		string.append("CREATE TABLE \"Orders\" (\r\n"
				+ "	\"OrderID\"	INTEGER,\r\n"
				+ "	\"CustomerID\"	INTEGER,\r\n"
				+ "	\"Status\"	INTEGER NOT NULL DEFAULT 0,\r\n"
				+ "	\"Discount\"	REAL NOT NULL DEFAULT 0,\r\n"
				+ "	\"CreationDate\"	datetime DEFAULT current_timestamp,\r\n"
				+ "	\"TotalCost\"	REAL DEFAULT 0,\r\n"
				+ "	PRIMARY KEY(\"OrderID\" AUTOINCREMENT),\r\n"
				+ "	FOREIGN KEY(\"CustomerID\") REFERENCES \"Customers\"(\"CustomerID\")\r\n"
				+ ");");
		return string.toString();
	}
	public String CreateTableOrderItems()
	{
		StringBuilder string = new StringBuilder();
		string.append("CREATE TABLE \"OrderItems\" (\r\n"
				+ "	\"OrderID\"	INTEGER,\r\n"
				+ "	\"ProductID\"	INTEGER,\r\n"
				+ "	\"Quantity\"	INTEGER NOT NULL DEFAULT 0,\r\n"
				+ "	\"PricePerUnit\"	REAL,\r\n"
				+ "	FOREIGN KEY(\"OrderID\") REFERENCES \"Orders\"(\"OrderID\"),\r\n"
				+ "	FOREIGN KEY(\"ProductID\") REFERENCES \"Products\"(\"ProductID\")\r\n"
				+ ");");
		return string.toString();
	}
	public String CreateTableSuppliers()
	{
		StringBuilder string = new StringBuilder();
		string.append("CREATE TABLE \"Suppliers\" (\r\n"
				+ "	\"SupplierID\"	INTEGER,\r\n"
				+ "	\"Name\"	TEXT NOT NULL,\r\n"
				+ "	\"Address\"	TEXT,\r\n"
				+ "	\"PhoneNumber\"	TEXT NOT NULL UNIQUE,\r\n"
				+ "	PRIMARY KEY(\"SupplierID\" AUTOINCREMENT)\r\n"
				+ ");");
		return string.toString();
	}
	public String CreateTableCustomers()
	{
		StringBuilder string = new StringBuilder();
		string.append("CREATE TABLE \"Customers\" (\r\n"
				+ "	\"CustomerID\"	INTEGER,\r\n"
				+ "	\"PhoneNumber\"	TEXT UNIQUE,\r\n"
				+ "	\"Name\"	TEXT DEFAULT 'V�ng lai',\r\n"
				+ "	PRIMARY KEY(\"CustomerID\" AUTOINCREMENT)\r\n"
				+ ");");
		return string.toString();
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("org.sqlite.JDBC");
		Creator creator = new Creator();
		Connection connection = DriverManager.getConnection("jdbc:sqlite:tt.db");
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(45);
		//need to drop if exists
		
		//CUSTOMERS
		statement.executeUpdate("DROP TABLE IF EXISTS Customers");
		statement.executeUpdate(creator.CreateTableCustomers());
		
		//SUPPLIERS
		statement.executeUpdate("DROP TABLE IF EXISTS Suppliers");
		statement.executeUpdate(creator.CreateTableSuppliers());
		
		//INGREDIENTS
		statement.executeUpdate("DROP TABLE IF EXISTS Ingredients");
		statement.executeUpdate(creator.CreateTableIngredients());
		
		//PRODUCTS
		statement.executeUpdate("DROP TABLE IF EXISTS Products");
		statement.executeUpdate(creator.CreateTableProducts());
		
		//BUYORDERS
		statement.executeUpdate("DROP TABLE IF EXISTS BuyOrders");
		statement.executeUpdate(creator.CreateTableBuyOrders());
		
		//BUYORDERSITEMS
		statement.executeUpdate("DROP TABLE IF EXISTS BuyOrderItems");
		statement.executeUpdate(creator.CreateTableBuyOrderItems());
		
		//ORDERS
		statement.executeUpdate("DROP TABLE IF EXISTS Orders");
		statement.executeUpdate(creator.CreateTableOrders());
				
		//ORDERITEMS
		statement.executeUpdate("DROP TABLE IF EXISTS OrderItems");
		statement.executeUpdate(creator.CreateTableOrderItems());
		
		//For testing purpose only
		
		statement.executeUpdate("INSERT INTO Customers values('1', '1', 'Hai')");
		ResultSet set = statement.executeQuery("SELECT * FROM Customers");
		while (set.next())
		{
			System.out.println("ID: " + set.getString("CustomerID"));
			System.out.println("Name: " + set.getString("Name"));
		}
	}

}
