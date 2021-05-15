package Query;

public class DroppingQuery {
	public static String dropCustomersTableQuery()
	{
		return "DROP TABLE IF EXISTS Customers";
	}
	public static String dropSuppliersTableQuery()
	{
		return "DROP TABLE IF EXISTS Suppliers";
	}
	public static String dropOrdersTableQuery()
	{
		return "DROP TABLE IF EXISTS Orders";
	}
	public static String dropBuyOrdersTableQuery()
	{
		return "DROP TABLE IF EXISTS BuyOrders";
	}
	public static String dropProductsTableQuery()
	{
		return "DROP TABLE IF EXISTS Products";
	}
	public static String dropIngredientsTableQuery()
	{
		return "DROP TABLE IF EXISTS Ingredients";
	}
	public static String dropOrderItemsTableQuery()
	{
		return "DROP TABLE IF EXISTS OrderItems";
	}
	public static String dropBuyOrderItemsTableQuery()
	{
		return "DROP TABLE IF EXISTS BuyOrderItems";
	}
	public static String dropIngreListTableQuery()
	{
		return "DROP TABLE IF EXISTS IngreList";
	}
	public static void main(String[] args){
		// TODO Auto-generated method stub
	
	}

}
