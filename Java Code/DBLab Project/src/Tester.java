import java.sql.*;
public class Tester {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println(DataConverter.createDateTimeString(0, 0, 0, 0, 0, 0));
		System.out.println(CustomersQuery.getCustomerNameQuery("0123132"));
	}

}
