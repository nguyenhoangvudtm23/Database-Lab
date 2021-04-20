package Execution;

import java.sql.SQLException;
import java.time.LocalDateTime;

import Query.IngredientQuery;

public class IngredientStatistics extends Execution {
	public static String getIngredientName(int ID) throws SQLException
	{
		return statement.executeQuery(IngredientQuery.getIngredientNameQuery(ID)).getString(1);
	}
	public static void updateIngredientName(int ID, String newName) throws SQLException
	{
		statement.executeUpdate(IngredientQuery.updateIngredientNameQuery(ID, newName));
	}
	public static double calculateOneIngredientCostFromToQuery(int ID, LocalDateTime from, LocalDateTime to) throws SQLException
	{
		return statement.executeQuery(IngredientQuery.calculateOneIngredientCostFromToQuery(ID, from, to)).getDouble(1);
	}
	public static double calculateAllIngredientsCostFromToQuery(LocalDateTime from, LocalDateTime to) throws SQLException
	{
		return statement.executeQuery(IngredientQuery.calculateAllIngredientCostFromToQuery(from, to)).getDouble(1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1D);
	}

}
