import java.sql.*;
public class OrderCreator {
	public static Statement statement;
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
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection("jdbc:sqlite:creation.db");
		statement = connection.createStatement();
		statement.setQueryTimeout(23);
		statement.setQueryTimeout(45);
		//System.out.println(OrderCreator.CheckExistQuery("0123"));
		ResultSet set = statement.executeQuery(OrderCreator.checkExistQuery("0912345671"));
		while (set.next())
		{
			int n = Integer.parseInt(set.getString(1));
			System.out.println(n);
			if (n == 1)
			{
				System.out.println("Exist");
			}
			else
			{
				System.out.println("Not yet");
			}
		}
	}

}
