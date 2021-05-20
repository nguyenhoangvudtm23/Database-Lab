package Classes;

public class Ingredient {
	public static int ID = 1;
	private int IngredientID;
	private double price;
	public int getIngredientID() {
		return IngredientID;
	}

	public static int getID() {
		return ID;
	}

	public static void setID(int iD) {
		ID = iD;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
		this.price = price;
	}
	

	
}
