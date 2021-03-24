import java.time.*;
public class OrderCreator {

	public static String checkExistQuery(String phoneNumber)
	{
		return "select count(*) from Customers\r\n"
				+ "where Phone_Number = " + "'" + phoneNumber + "'";
	}
	public static String addOrderQuery(int CustomerID,
			double TotalCost, char status, double discount)
	{
		return "insert into Orders \r\n"
				+ "(\"CustomerID\", \"Totalcost\", \"CreationDate\", \"Status\", \"Discount\")\r\n"
				+ "VALUES\r\n"
				+ "(" + Integer.toString(CustomerID) + ", "
				+ Double.toString(TotalCost) + ", "
				+ "'now', '"
				+ Character.toString(status) + "', "
				+ Double.toString(discount) + ")";
	}
	public static String addCustomerQuery(String address,
			String phoneNumber, String Name, String email)
	{
		return "insert into Customers\r\n"
				+ "(\"Address\", \"Phone_Number\", \"Name\", \"Email\")"
				+ "\nVALUES ('"
				+ address + "', '"
				+ phoneNumber + "', '"
				+ Name + "', '"
				+ email + "')";
	}
	public static void main(String[] args){
		System.out.println(OrderCreator.addCustomerQuery("Hao", "A", "B", "C"));
	}

}
