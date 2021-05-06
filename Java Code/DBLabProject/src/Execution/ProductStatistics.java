package Execution;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import Query.OrderQuery;
import Query.ProductQuery;

public class ProductStatistics extends Execution {
	//return product name only
	public static void recordItemIntoOrder(int OrderID, int ProductID, int quantity) throws SQLException
	{
		statement.executeUpdate(OrderQuery.recordItemIntoOrderQuery(OrderID, ProductID, quantity));
	}
	public static String getProductName(int ID) throws SQLException
	{
		return statement.executeQuery(ProductQuery.getProductNameQuery(ID)).getString(1);
	}
	//return total revenue of 1 product during a period of time only
	public static double calculateOneProductRevenueFromTo(int ProductID, LocalDateTime from, LocalDateTime to) throws SQLException
	{
		return statement.executeQuery(ProductQuery.calculateOneProductRevenueFromToQuery(ProductID, from, to)).getDouble(1);
	}
	//return 2 columns - ProductID and its total revenue during a period of time
	public static ResultSet calculateAllProductRevenueFromTo(LocalDateTime from, LocalDateTime to) throws SQLException
	{
		return statement.executeQuery(ProductQuery.calculateAllProductRevenueFromToQuery(from, to));
	}
	//return product's price only
	public static double getProductPrice(int ID) throws SQLException
	{
		return statement.executeQuery(ProductQuery.getProductPriceQuery(ID)).getDouble(1);
	}
	//Update Product's Price
	public static void updateProductPrice(int ProductID, double newPrice) throws SQLException
	{
		statement.executeUpdate(ProductQuery.updatePriceQuery(ProductID, newPrice));
	}
	//Update Product's Name
	public static void updateProductName(int ProductID, String newName) throws SQLException
	{
		statement.executeUpdate(ProductQuery.updateNameQuery(ProductID, newName));
	}
	public static ResultSet getProductsWithSimilarName(String pattern) throws SQLException
	{
		return statement.executeQuery(ProductQuery.getProductsWithSimilarNameQuery(pattern));
	}
	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		ProductStatistics.getConnection();
		ProductStatistics.updateProductName(1, "Beefsteak");;
	}
}
