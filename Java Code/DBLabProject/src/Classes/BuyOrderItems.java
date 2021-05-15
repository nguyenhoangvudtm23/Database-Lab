package Classes;

public class BuyOrderItems {
	private int BuyOrderID;
	private int IngredientID;
	private int Quantity;
	private double PricePerUnit;
	public int getBuyOrderID() {
		return BuyOrderID;
	}
	public void setBuyOrderID(int buyOrderID) {
		BuyOrderID = buyOrderID;
	}
	public int getIngredientID() {
		return IngredientID;
	}
	public void setIngredientID(int ingredientID) {
		IngredientID = ingredientID;
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
	public BuyOrderItems(int buyOrderID, int ingredientID, int quantity, double pricePerUnit) {
		super();
		BuyOrderID = buyOrderID;
		IngredientID = ingredientID;
		Quantity = quantity;
		PricePerUnit = pricePerUnit;
	}
	public BuyOrderItems() {
		// TODO Auto-generated constructor stub
	}

}
