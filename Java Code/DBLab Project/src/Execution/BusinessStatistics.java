package Execution;

import java.sql.SQLException;
import java.time.LocalDateTime;

import Query.BusinessQuery;

public class BusinessStatistics extends Execution {
	public static double calculateRevenueFromTo(LocalDateTime from, LocalDateTime to) throws SQLException
	{
		return statement.executeQuery(BusinessQuery.calculateTotalRevenueFromToQuery(from, to)).getDouble(1);
	}
	public static double calculateCostFromTo(LocalDateTime from, LocalDateTime to) throws SQLException
	{
		return statement.executeQuery(BusinessQuery.calculateTotalCostFromToQuery(from, to)).getDouble(1);
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		BusinessStatistics.getConnection();
		System.out.println(BusinessStatistics.calculateCostFromTo(LocalDateTime.of(2015, 2, 2, 2, 2), LocalDateTime.of(2021, 4, 4, 4, 4)));
		
	}
}
