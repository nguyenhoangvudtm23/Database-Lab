package Query;

public class SuppliersQuery {
	public static String getSuppliersWithSimilarNameToQuery(String s)
	{
		return "select * from Suppliers \r\n"
				+ "where name like '%" + s + "%'";
	}
	
	public static String checkExistQuery(String phoneNumber)
	{
		return "select count(*) from Suppliers\r\n"
				+ "where Phone_Number = " + "'" + phoneNumber + "'";
	}
	public static String getSupplierNameQuery(int ID)
	{
		return "select Name from Suppliers\r\n"
				+ "where SupplierID = " + ID;
	}
	public static String getSupplierNameQuery(String phoneNumber)
	{
		return "select Name from Suppliers\r\n"
				+ "where Phone_Number = '" + phoneNumber + "'";
	}
	public static String getSupplierIDQuery(String phoneNumber)
	{
		return "select SupplierID from Suppliers\r\n"
				+ "where Phone_Number = '" + phoneNumber + "'";
	}
	public static String updateSupplierNameQuery(int ID, String newName)
	{
		return "update Suppliers\r\n"
				+ "set Name = '" + newName + "'\r\n"
				+ "where SupplierID = " + ID;
	}
	public static String updateSupplierPhoneNumberQuery(int ID, String newPhone)
	{
		return "update Suppliers\r\n"
				+ "set Phone_Number = '" + newPhone + "'\r\n"
				+ "where SupplierID = " + ID;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SuppliersQuery.updateSupplierPhoneNumberQuery(2, "0812321342"));
	}

}
