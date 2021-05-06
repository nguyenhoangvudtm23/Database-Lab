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
	public static int getSupplierID(String phoneNumber) throws SQLException
	{
		return statement.executeQuery(SuppliersQuery.getSupplierIDQuery(phoneNumber)).getInt(1);
	}
	public static void updateSupplierName(int SupplierID, String newName) throws SQLException
	{
		statement.executeUpdate(SuppliersQuery.updateSupplierNameQuery(SupplierID, newName));
	}
	public static void updateSupplierPhoneNumber(int SupplierID, String newPhoneNumber) throws SQLException
	{
		statement.executeUpdate(SuppliersQuery.updateSupplierNameQuery(SupplierID, newPhoneNumber));
	}
	public static int checkExist(String phoneNumber) throws SQLException
	{
		return statement.executeQuery(SuppliersQuery.checkExistQuery(phoneNumber)).getInt(1);
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		SupplierStatistics.getConnection();
		System.out.println(SupplierStatistics.getSupplierName(2));
	}
}
