package Query;

public class BuyOrderQuery {
	public static String deleteBuyOrderQuery(int BuyOrderID)
	{
		return "delete from BuyOrders\r\n"
				+ "where BuyOrderID = " + BuyOrderID;
	}
	public static String showBuyOrderItemsQuery(int BuyOrderID)
	{
		return "select * from BuyOrders, BuyOrderItems where"
				+ " (BuyOrders.BuyOrderID = " + BuyOrderID + ") AND (BuyOrders.BuyOrderID = BuyOrderItems.BuyOrderID)";
	}
	public static String calculateTotalCostQuery(int BuyOrderID)
	{
		return "select sum(Quantity * PricePerUnit) from BuyOrderItems where"
				+ " (BuyOrderItems.BuyOrderID = " + BuyOrderID + ")";
	}
	public static void main(String args[])
	{
		System.out.println(BuyOrderQuery.deleteBuyOrderQuery(0));
		System.out.println(BuyOrderQuery.showBuyOrderItemsQuery(0));
		System.out.println(BuyOrderQuery.calculateTotalCostQuery(0));
	}
}
