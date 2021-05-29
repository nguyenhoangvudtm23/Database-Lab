package Query;

public class BuyOrderQuery {
	public static String updateBuyOrdersSupplierIDQuery(int BuyOrderID, int newSupplierID)
	{
		return "update BuyOrders\r\n"
				+ "set SupplierID = '" + newSupplierID + "'\r\n"
				+ "where BuyOrdersID = " + BuyOrderID;
	}
	public static String updateBuyOrdersStatusQuery(int BuyOrderID, char newStatus)
	{
		return "update BuyOrders\r\n"
				+ "set Status = '" + newStatus + "'\r\n"
				+ "where BuyOrdersID = " + BuyOrderID;
	}
	public static String updateBuyOrderItemsQuantityQuery(int BuyOrderID, int IngredientID, int newQuantity)
	{
		return "update BuyOrderItems\r\n"
				+ "set Quantity = '" + newQuantity + "'\r\n"
				+ "where BuyOrdersID = " + BuyOrderID + " and IngredientID = " + IngredientID;
	}
	public static String updateBuyOrderItemsPricePerUnitQuery(int BuyOrderID, int IngredientID, double newPricePerUnit)
	{
		return "update BuyOrderItems\r\n"
				+ "set PricePerUnit = '" + newPricePerUnit + "'\r\n"
				+ "where BuyOrdersID = " + BuyOrderID + " and IngredientID = " + IngredientID;
	}
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
	public static String selectAllBuyOrdersQuery()
	{
		return "select BuyOrderID, SupplierID, Totalcost, CreationDate, Status\r\n"
				+ "from BuyOrders";
	}
	public static void main(String args[])
	{
		System.out.println(BuyOrderQuery.deleteBuyOrderQuery(0));
		System.out.println(BuyOrderQuery.showBuyOrderItemsQuery(0));
		System.out.println(BuyOrderQuery.calculateTotalCostQuery(0));
	}
}
