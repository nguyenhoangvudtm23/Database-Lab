package Classes;

public class Product {
	public static int ID = 1;
	private String ProductID;
	private Integer AmountLeft;
	private String Name;
	private Double price;
	private String Description;
	private int cur_quantity;
	public String getProductID() {
		return ProductID;
	}
	public void setCur_quantity(Integer cur_quantity) {
		this.cur_quantity = cur_quantity;
	}
	public int getAmountLeft() {
		return AmountLeft;
	}
	public void setProductID(String productID) {
		ProductID = productID;
	}
	public void setAmountLeft(Integer amountLeft) {
		AmountLeft = amountLeft;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Double getPrice() {
		return price;
	}
	public String getDescription() {
		return Description;
	}
	public String getName() {
		return Name;
	}
	public Product(int AmountLeft, String Name, Double price, String Description) {
		cur_quantity = 0;
		this.ProductID = String.valueOf(ID++);
		this.AmountLeft = AmountLeft;
		this.Name = Name;
		this.price = price;
		this.Description = Description;
	}
	public Product(int AmountLeft, String Name, Double price) {
		this(AmountLeft, Name, price, " ");
	}
	public Integer getCur_quantity() {
		return cur_quantity;
	}
	public String printInformation() {
		String s = String.format("%20s%20s%20d%20f", ProductID, Name, cur_quantity, price);
		return s;
	}
	
}
