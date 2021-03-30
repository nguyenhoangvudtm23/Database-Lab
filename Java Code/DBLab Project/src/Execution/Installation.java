package Execution;
import java.sql.*;

import Query.CreatingQuery;
import Query.DroppingQuery;
public class Installation extends Execution{
	//Create all 9 tables 
	public static void createAllTables() throws SQLException
	{
		//BUYORDERITEMS TABLE
		statement.executeUpdate(DroppingQuery.dropBuyOrderItemsTableQuery());
		statement.executeUpdate(CreatingQuery.createTableBuyOrderItemsQuery());
		
		//CUSTOMERS
		statement.executeUpdate(DroppingQuery.dropCustomersTableQuery());
		statement.executeUpdate(CreatingQuery.createTableCustomersQuery());
		
		//BUYORDERS TABLE
		statement.executeUpdate(DroppingQuery.dropBuyOrdersTableQuery());
		statement.executeUpdate(CreatingQuery.createTableBuyOrdersQuery());
		
		//SUPPLIERS
		statement.executeUpdate(DroppingQuery.dropSuppliersTableQuery());
		statement.executeUpdate(CreatingQuery.createTableSuppliersQuery());
		
		//INGREDIENTS TABLE
		statement.executeUpdate(DroppingQuery.dropIngredientsTableQuery());
		statement.executeUpdate(CreatingQuery.createTableIngredientsQuery());
		
		//ORDERS TABLE
		statement.executeUpdate(DroppingQuery.dropOrdersTableQuery());
		statement.executeUpdate(CreatingQuery.createTableOrdersQuery());
		
		//ORDERITEMS TABLE
		statement.executeUpdate(DroppingQuery.dropOrderItemsTableQuery());
		statement.executeUpdate(CreatingQuery.createTableOrderItemsQuery());
		
		//INGRELIST TABLE
		statement.executeUpdate(DroppingQuery.dropIngreListTableQuery());
		statement.executeUpdate(CreatingQuery.createTableIngreListQuery());
		
		//PRODUCTS
		statement.executeUpdate(DroppingQuery.dropProductsTableQuery());
		statement.executeUpdate(CreatingQuery.createTableProductsQuery());
	}
	public static void dropAllTables() throws SQLException
	{
		statement.executeUpdate(DroppingQuery.dropOrderItemsTableQuery());
		statement.executeUpdate(DroppingQuery.dropOrdersTableQuery());
		statement.executeUpdate(DroppingQuery.dropBuyOrderItemsTableQuery());
		statement.executeUpdate(DroppingQuery.dropBuyOrdersTableQuery());
		statement.executeUpdate(DroppingQuery.dropCustomersTableQuery());
		statement.executeUpdate(DroppingQuery.dropIngredientsTableQuery());
		statement.executeUpdate(DroppingQuery.dropIngreListTableQuery());
		statement.executeUpdate(DroppingQuery.dropProductsTableQuery());
		statement.executeUpdate(DroppingQuery.dropSuppliersTableQuery());
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Installation.getConnection();
		Installation.createAllTables();
	}

}
