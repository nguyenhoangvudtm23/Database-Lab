package Classes;

public class Products {
	private int ProductID;
	private int Amount_Left;
	private double Selling_Price;
	private String Product_Description;
	
	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public int getAmount_Left() {
		return Amount_Left;
	}

	public void setAmount_Left(int amount_Left) {
		Amount_Left = amount_Left;
	}

	public double getSelling_Price() {
		return Selling_Price;
	}

	public void setSelling_Price(double selling_Price) {
		Selling_Price = selling_Price;
	}

	public String getProduct_Description() {
		return Product_Description;
	}

	public void setProduct_Description(String product_Description) {
		Product_Description = product_Description;
	}

	public Products(int productID, int amount_Left, double selling_Price, String product_Description) {
		super();
		ProductID = productID;
		Amount_Left = amount_Left;
		Selling_Price = selling_Price;
		Product_Description = product_Description;
	}

	public Products() {
		// TODO Auto-generated constructor stub
	}

}
