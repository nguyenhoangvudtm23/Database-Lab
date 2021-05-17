package Execution;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import Query.IngredientQuery;

public class IngredientStatistics extends Execution {
	public static void insertIngredient(String name, String description, double price, int amountleft) throws SQLException
	{
		statement.executeUpdate(IngredientQuery.insertIngredientQuery(name, description, price, amountleft));
	}
	public static ResultSet getAllIngredient() throws SQLException
	{
		return statement.executeQuery(IngredientQuery.getAllIngredientQuery());
	}
	public static String getIngredientName(int ID) throws SQLException
	{
		return statement.executeQuery(IngredientQuery.getIngredientNameQuery(ID)).getString(1);
	}
	public static void updateIngredientName(int ID, String newName) throws SQLException
	{
		statement.executeUpdate(IngredientQuery.updateIngredientNameQuery(ID, newName));
	}
	public static void updateIngredientdescriptionQuery(int ID, String newdescription) throws SQLException
	{
		statement.executeUpdate(IngredientQuery.updateIngredientdescriptionQuery(ID, newdescription));
	}
	public static void updateIngreListQuantityQuery(int ProductID, int IngredientID, int newQuantity) throws SQLException
	{
		statement.executeUpdate(IngredientQuery.updateIngreListQuantityQuery(ProductID, IngredientID, newQuantity));
	}
	public static double calculateOneIngredientCostFromToQuery(int ID, LocalDateTime from, LocalDateTime to) throws SQLException
	{
		return statement.executeQuery(IngredientQuery.calculateOneIngredientCostFromToQuery(ID, from, to)).getDouble(1);
	}
	public static double calculateAllIngredientsCostFromToQuery(LocalDateTime from, LocalDateTime to) throws SQLException
	{
		return statement.executeQuery(IngredientQuery.calculateAllIngredientCostFromToQuery(from, to)).getDouble(1);
	}
	public static ResultSet getIngredientsWithSimilarName(String pattern) throws SQLException
	{
		return statement.executeQuery(IngredientQuery.getIngredientsWithSimilarNameQuery(pattern));
	}
	public static ResultSet topXmostcostingredientsYdays(int x, int y) throws SQLException
	{
		return statement.executeQuery(IngredientQuery.topXmostcostingredientsYdaysQuery(x, y));
	}
	public static ResultSet topXmostcostingredientsYmonths(int x, int y) throws SQLException
	{
		return statement.executeQuery(IngredientQuery.topXmostcostingredientsYmonthsQuery(x, y));
	}
	public static ResultSet topXmostcostingredientsYyears(int x, int y) throws SQLException
	{
		return statement.executeQuery(IngredientQuery.topXmostcostingredientsYyearsQuery(x, y));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1D);
	}

}