package Execution;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import Query.BusinessQuery;
import Query.CustomersQuery;

public class BusinessStatistics extends Execution {
	//Return total Revenue only
	public static double calculateRevenueFromTo(LocalDateTime from, LocalDateTime to) throws SQLException
	{
		return statement.executeQuery(BusinessQuery.calculateTotalRevenueFromToQuery(from, to)).getDouble(1);
	}
	//Return total Cost only
	public static double calculateCostFromTo(LocalDateTime from, LocalDateTime to) throws SQLException
	{
		return statement.executeQuery(BusinessQuery.calculateTotalCostFromToQuery(from, to)).getDouble(1);
	}
	//Return average Spending per Order FROM TO only
	public static double calculateAverageSpendPerOrderFromTo(LocalDateTime from, LocalDateTime to) throws SQLException
	{
		return statement.executeQuery(BusinessQuery.calculateAverageSpendPerOrderFromToQuery(from, to)).getDouble(1);
	}
	//Return a set of pair <String - Double> of <DateTimeFormat - Total of All Bills which satisfy the conditions>
	public static ResultSet calculateTotalRevenueLastXYears(int x) throws SQLException
	{
		return statement.executeQuery(BusinessQuery.calculateTotalRevenueLastXYearsQuery(x));
	}
	public static ResultSet calculateTotalRevenueLastXMonths(int x) throws SQLException
	{
		return statement.executeQuery(BusinessQuery.calculateTotalRevenueLastXMonthsQuery(x));
	}
	public static ResultSet calculateTotalRevenueLastXWeeks(int x) throws SQLException
	{
		return statement.executeQuery(BusinessQuery.calculateTotalCostLastXWeeksQuery(x));
	}
	public static ResultSet calculateTotalRevenueLastXDays(int x) throws SQLException
	{
		return statement.executeQuery(BusinessQuery.calculateTotalRevenueLastXDaysQuery(x));
	}
	public static ResultSet calculateTotalCostLastXYears(int x) throws SQLException
	{
		return statement.executeQuery(BusinessQuery.calculateTotalCostLastXYearsQuery(x));
	}
	public static ResultSet calculateTotalCostLastXMonths(int x) throws SQLException
	{
		return statement.executeQuery(BusinessQuery.calculateTotalCostLastXMonthsQuery(x));
	}
	public static ResultSet calculateTotalCostLastXWeeks(int x) throws SQLException
	{
		return statement.executeQuery(BusinessQuery.calculateTotalCostLastXWeeksQuery(x));
	}
	public static ResultSet calculateTotalCostLastXDays(int x) throws SQLException
	{
		return statement.executeQuery(BusinessQuery.calculateTotalCostLastXDaysQuery(x));
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		BusinessStatistics.getConnection();
		System.out.println(BusinessStatistics.calculateAverageSpendPerOrderFromTo(LocalDateTime.MIN, LocalDateTime.now()));
		
	}
}
