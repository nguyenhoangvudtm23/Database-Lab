package Execution;

import java.sql.ResultSet;
import java.sql.SQLException;

import Query.SuppliersQuery;

public class SupplierStatistics extends Execution {
	public static ResultSet getSuppliersWithSimilarNameTo(String s) throws SQLException
	{
		return statement.executeQuery(SuppliersQuery.getSuppliersWithSimilarNameToQuery(s));
	}
	public static String getSupplierName(int ID) throws SQLException
	{
		return statement.executeQuery(SuppliersQuery.getSupplierNameQuery(ID)).getString(1);
	}
	public static String getSupplierName(String phoneNumber) throws SQLException
	{
		return statement.executeQuery(SuppliersQuery.getSupplierNameQuery(phoneNumber)).getString(1);
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		SupplierStatistics.getConnection();
		System.out.println(SupplierStatistics.getSupplierName(2));
	}
}
