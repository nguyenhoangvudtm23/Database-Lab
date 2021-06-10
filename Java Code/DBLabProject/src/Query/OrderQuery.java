package Query;
import java.time.*;
public class OrderQuery {
	public static String updateOrderItemsQuantityQuery(int OrderID, int ProductID, int newQuantity)
	{
		return "update OrderItems\r\n"
				+ "set Quantity = '" + newQuantity + "'\r\n"
				+ "where OrdersID = " + OrderID + " and ProductID = " + ProductID;
	}
	public static String updateOrdersStatusQuery(int OrderID, char newStatus)
	{
		return "update Orders\r\n"
				+ "set Status = '" + newStatus + "'\r\n"
				+ "where OrdersID = " + OrderID;
	}
	public static String updateOrdersDiscountQuery(int OrderID, int newDiscount)
	{
		return "update Orders\r\n"
				+ "set Discount = '" + newDiscount + "'\r\n"
				+ "where OrdersID = " + OrderID;
	}
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
	public static String removeItemFromOrderQuery(int OrderID, int ProductID)
	{
		return "delete from OrderItems WHERE\r\n"
				+ "OrderID = " + OrderID +  "and ProductID = " + ProductID;
	}
	public static String calculateTotalCostQuery(int OrderID)
	{
		return "select sum(Quantity * PricePerUnit)\r\n"
				+ "from OrderItems\r\n"
				+ "where OrderID = " + OrderID;
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
	//Price Per Unit will be gotten from Products table based on ProductID 
	public static String recordItemIntoOrderQuery(int OrderID, int ProductID, int quantity)
	{
		return "insert into OrderItems\r\n"
				+ "(OrderID, ProductID, Quantity, PricePerUnit)\r\n"
				+ "values (" + OrderID + "," + ProductID + "," + quantity + ", (SELECT Selling_Price FROM Products where ProductID =" + ProductID +  "))";
	}
	public static String displayAllItemsInOrderQuery(int OrderID)
	{
		return "select OrderItems.ProductID as PID, Products.Product_Descript AS Name, OrderItems.Quantity AS [Amount], OrderItems.PricePerUnit AS [Price Per Unit]  from OrderItems, Products where \r\n"
				+ "Products.ProductID = OrderItems.ProductID\r\n"
				+ "and OrderID = " + OrderID;
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
	public static String selectAllOrdersQuery()
	{
		return "select OrderID, CustomerID, Totalcost, CreationDate, Status, Discount\r\n"
				+ "from Orders";
	}
	public static String lastOrderIDQuery()
	{
		return "select MAX(OrderID) From Orders";
	}
	public static void main(String[] args){
		System.out.println(OrderQuery.recordItemIntoOrderQuery(3, 2, 4));
	}
	
}
