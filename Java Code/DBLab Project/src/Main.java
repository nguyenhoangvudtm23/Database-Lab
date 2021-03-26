import java.sql.*;
public class Main {
	static Statement statement;
	static Connection connection = null;
	public static void getConnection() throws SQLException, ClassNotFoundException 
	{
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:creation.db");
		statement = connection.createStatement();
        statement.setQueryTimeout(30); 
	}
	public static void createAllTables() throws SQLException
	{
		//BUYORDERITEMS TABLE
		statement.executeUpdate(Destructor.dropBuyOrderItemsTableQuery());
		statement.executeUpdate(Creator.createTableBuyOrderItemsQuery());
		
		//CUSTOMERS
		statement.executeUpdate(Destructor.dropCustomersTableQuery());
		statement.executeUpdate(Creator.createTableCustomersQuery());
		
		//BUYORDERS TABLE
		statement.executeUpdate(Destructor.dropBuyOrdersTableQuery());
		statement.executeUpdate(Creator.createTableBuyOrdersQuery());
		
		//SUPPLIERS
		statement.executeUpdate(Destructor.dropSuppliersTableQuery());
		statement.executeUpdate(Creator.createTableSuppliersQuery());
		
		//INGREDIENTS TABLE
		statement.executeUpdate(Destructor.dropIngredientsTableQuery());
		statement.executeUpdate(Creator.createTableIngredientsQuery());
		
		//ORDERS TABLE
		statement.executeUpdate(Destructor.dropOrdersTableQuery());
		statement.executeUpdate(Creator.createTableOrdersQuery());
		
		//ORDERITEMS TABLE
		statement.executeUpdate(Destructor.dropOrderItemsTableQuery());
		statement.executeUpdate(Creator.createTableOrderItemsQuery());
		
		//INGRELIST TABLE
		statement.executeUpdate(Destructor.dropIngreListTableQuery());
		statement.executeUpdate(Creator.createTableIngreListQuery());
		
		//PRODUCTS
		statement.executeUpdate(Destructor.dropProductsTableQuery());
		statement.executeUpdate(Creator.createTableProductsQuery());
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Main.getConnection();
		Main.createAllTables();
	}

}
