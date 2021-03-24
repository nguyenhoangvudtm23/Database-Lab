import java.time.*;
public class OrderCreator {

	public static String checkExistQuery(String phoneNumber)
	{
		return "select count(*) from Customers\r\n"
				+ "where Phone_Number = " + "'" + phoneNumber + "'";
	}
	public static String addOrderQuery()
	{
		return "";
	}
	public static String addCustomerQuery()
	{
		return "";
	}
	public static void main(String[] args){
		
	}

}
