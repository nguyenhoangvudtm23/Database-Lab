package Classes;

public class Ingredient {
	public static int ID = 1;
	private int IngredientID;
	private double Price;
	private Integer cur_quantity;
	public int getIngredientID() {
		return IngredientID;
	}


	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		this.Price = price;
	}

	public void setIngredientID(int ingredientID) {
		IngredientID = ingredientID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getAmountLeft() {
		return AmountLeft;
	}

	public void setAmountLeft(int amountLeft) {
		AmountLeft = amountLeft;
	}

	private String Name;
	private String Description;
	private int AmountLeft;
	
	public Ingredient(String Name, double price, String Description, int AmountLeft) {
		IngredientID = ID++;
		this.Name = Name;
		this.Description = Description;
		this.AmountLeft = AmountLeft;
		this.Price = price;
		this.cur_quantity = 0;
	}

	public Integer getCur_quantity() {
		return cur_quantity;
	}

	public void setCur_quantity(Integer cur_quantity) {
		this.cur_quantity = cur_quantity;
	}
	public String printInformation() {
		// TODO Auto-generated method stub
		String s = String.format("%20s%20s%20d%20f", IngredientID, Name, cur_quantity, Price);
		return s;
	}
	

	
}
