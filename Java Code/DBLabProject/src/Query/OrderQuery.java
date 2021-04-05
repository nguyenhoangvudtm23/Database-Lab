package Query;
import java.time.*;
public class OrderQuery {
	
	public static String deleteOrderQuery(int OrderID)
	{
		return "delete from Orders\r\n"
				+ "where OrderID = " + OrderID;
	}
	public static String showOrderItemsQuery(int OrderID)
	{
		return "select OI.ProductID, OI.Quantity, P.Product_Descript, P.Selling_Price from OrderItems AS OI, Products as P\r\n"
				+ "where (OI.OrderID = " + OrderID + ") and (OI.ProductID = P.ProductID)";
	}
	public static String addOrderQuery(int CustomerID,
			double TotalCost, char status, double discount)
	{
		return "insert into Orders \r\n"
				+ "(\"CustomerID\", \"Totalcost\", \"CreationDate\", \"Status\", \"Discount\")\r\n"
				+ "VALUES\r\n"
				+ "(" + Integer.toString(CustomerID) + ", "
				+ Double.toString(TotalCost) + ", "
				+ "DATE('now'), '"
				+ Character.toString(status) + "', "
				+ Double.toString(discount) + ")";
	}
	public static String recordItemIntoOrderQuery(int OrderID, int ProductID, int quantity, double PricePerUnit)
	{
		return "insert into orderitems (OrderID, ProductID, Quantity, PricePerUnit) \r\n"
				+ "VALUES (" + OrderID + "," + ProductID + "," + quantity + "," + PricePerUnit   + ")";
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
		System.out.println(OrderQuery.showOrderItemsQuery(2));
	}

}
