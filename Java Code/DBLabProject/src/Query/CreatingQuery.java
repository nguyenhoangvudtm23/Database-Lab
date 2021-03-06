package Query;
public class CreatingQuery {
	
	public static String createTableIngredientsQuery()
	{
		return "CREATE TABLE \"Ingredients\" (\r\n"
				+ "	\"IngredientID\"	INTEGER,\r\n"
				+ "	\"Name\"	VARCHAR(40),\r\n"
				+ "	\"description\"	VARCHAR(40),\r\n"
				+ "	\"Amount_Left\"	INTEGER,\r\n"
				+ "	PRIMARY KEY(\"IngredientID\" AUTOINCREMENT)\r\n"
				+ ");";
	}
	public static String createTableProductsQuery()
	{
		
		return "CREATE TABLE \"Products\" (\r\n"
				+ "	\"ProductID\"	INTEGER,\r\n"
				+ "	\"Amount_Left\"	INTEGER,\r\n"
				+ "	\"Selling_Price\"	DOUBLE,\r\n"
				+ "	\"Product_Descript\"	VARCHAR(40),\r\n"
				+ "	PRIMARY KEY(\"ProductID\" AUTOINCREMENT)\r\n"
				+ ");";
	}
	public static String createTableBuyOrdersQuery()
	{
		return "CREATE TABLE \"BuyOrders\" (\r\n"
				+ "	\"BuyOrderID\"	INTEGER,\r\n"
				+ "	\"SupplierID\"	INTEGER,\r\n"
				+ "	\"Totalcost\"	DOUBLE,\r\n"
				+ "	\"CreationDate\"	DATETIME,\r\n"
				+ "	\"Status\"	VARCHAR(1),\r\n"
				+ "	PRIMARY KEY(\"BuyOrderID\" AUTOINCREMENT),\r\n"
				+ "	CONSTRAINT \"check_status_buyorders\" CHECK(\"Status\" = 'C' OR \"Status\" = 'P' OR \"Status\" = 'S' OR \"Status\" = 'F')\r\n"
				+ ");";
	}
	public static String createTableBuyOrderItemsQuery()
	{
		return "CREATE TABLE \"BuyOrderItems\" (\r\n"
				+ "	\"BuyOrderID\"	INTEGER,\r\n"
				+ "	\"IngredientID\"	INTEGER,\r\n"
				+ "	\"Quantity\"	INTEGER,\r\n"
				+ "	\"PricePerUnit\"	DOUBLE,\r\n"
				+ "	CONSTRAINT \"buyorderitems_fk_buyorders\" FOREIGN KEY(\"BuyOrderID\") REFERENCES \"BuyOrders\"(\"BuyOrderID\") ON DELETE SET NULL,\r\n"
				+ "	CONSTRAINT \"buyorderitems_fk_ingredients\" FOREIGN KEY(\"IngredientID\") REFERENCES \"Ingredients\"(\"IngredientID\") ON DELETE SET NULL\r\n"
				+ ");";
	}
	public static String createTableOrdersQuery()
	{
		
		return "CREATE TABLE \"Orders\" (\r\n"
				+ "	\"OrderID\"	INTEGER,\r\n"
				+ "	\"CustomerID\"	INTEGER,\r\n"
				+ "	\"Totalcost\"	DOUBLE,\r\n"
				+ "	\"CreationDate\"	DATETIME,\r\n"
				+ "	\"Status\"	VARCHAR(1),\r\n"
				+ "	\"Discount\"	INTEGER,\r\n"
				+ "	PRIMARY KEY(\"OrderID\" AUTOINCREMENT),\r\n"
				+ "	CONSTRAINT \"check_status\" CHECK(\"Status\" = 'C' OR \"Status\" = 'P' OR \"Status\" = 'S' OR \"Status\" = 'F'),\r\n"
				+ "	CONSTRAINT \"orders_fk_customers\" FOREIGN KEY(\"CustomerID\") REFERENCES \"Customers\"(\"CustomerID\") ON DELETE SET NULL\r\n"
				+ ");";
	}
	public static String createTableOrderItemsQuery()
	{

		return "CREATE TABLE \"OrderItems\" (\r\n"
				+ "	\"OrderID\"	INTEGER,\r\n"
				+ "	\"ProductID\"	INTEGER,\r\n"
				+ "	\"Quantity\"	INTEGER,\r\n"
				+ "	\"PricePerUnit\"	DOUBLE,\r\n"
				+ "	CONSTRAINT \"orderitems_fk_products\" FOREIGN KEY(\"ProductID\") REFERENCES \"Products\"(\"ProductID\") ON DELETE SET NULL,\r\n"
				+ "	CONSTRAINT \"orderitems_fk_orders\" FOREIGN KEY(\"OrderID\") REFERENCES \"Orders\"(\"OrderID\") ON DELETE SET NULL\r\n"
				+ ");";
	}
	public static String createTableSuppliersQuery()
	{
		
		return "CREATE TABLE \"Suppliers\" (\r\n"
				+ "	\"SupplierID\"	INTEGER,\r\n"
				+ "	\"Name\"	VARCHAR(40),\r\n"
				+ "	\"Address\"	VARCHAR(40),\r\n"
				+ "	\"Phone_Number\"	VARCHAR(14),\r\n"
				+ "	\"Email\"	VARCHAR(40),\r\n"
				+ "	PRIMARY KEY(\"SupplierID\" AUTOINCREMENT)\r\n"
				+ ");";
	}
	public static String createTableCustomersQuery()
	{
		
		return "CREATE TABLE \"Customers\" (\r\n"
				+ "	\"CustomerID\"	INTEGER,\r\n"
				+ "	\"Address\"	VARCHAR(40),\r\n"
				+ "	\"Phone_Number\"	VARCHAR(14),\r\n"
				+ "	\"Name\"	VARCHAR(40),\r\n"
				+ "	\"Email\"	VARCHAR(40),\r\n"
				+ "	PRIMARY KEY(\"CustomerID\" AUTOINCREMENT)\r\n"
				+ ");";
	}
	public static String createTableIngreListQuery()
	{
		return "CREATE TABLE \"IngreList\" (\r\n"
				+ "	\"ProductID\"	INTEGER,\r\n"
				+ "	\"IngredientID\"	INTEGER,\r\n"
				+ "	\"Quantity\"	INTEGER,\r\n"
				+ "	CONSTRAINT \"ingrelist_fk_ingredients\" FOREIGN KEY(\"IngredientID\") REFERENCES \"Ingredients\"(\"IngredientID\") ON DELETE SET NULL,\r\n"
				+ "	CONSTRAINT \"ingrelist_fk_products\" FOREIGN KEY(\"ProductID\") REFERENCES \"Products\"(\"ProductID\") ON DELETE SET NULL\r\n"
				+ ");";
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		
	}

}
