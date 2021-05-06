package Classes;

public class IngreList {
	private int ProductID;
	private int IngredientID;
	private int Quantity;
	
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
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
	public IngreList(int productID, int ingredientID, int quantity) {
		super();
		ProductID = productID;
		IngredientID = ingredientID;
		Quantity = quantity;
	}
	public IngreList() {
		// TODO Auto-generated constructor stub
	}

}
