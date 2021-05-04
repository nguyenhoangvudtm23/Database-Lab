package Classes;

public class OrderItems {
	private int OrderID;
	private int ProductID;
	private int Quantity;
	private double PricePerUnit;
	
	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getPricePerUnit() {
		return PricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		PricePerUnit = pricePerUnit;
	}

	public OrderItems(int orderID, int productID, int quantity, double pricePerUnit) {
		super();
		OrderID = orderID;
		ProductID = productID;
		Quantity = quantity;
		PricePerUnit = pricePerUnit;
	}

	public OrderItems() {
		// TODO Auto-generated constructor stub
	}

}
