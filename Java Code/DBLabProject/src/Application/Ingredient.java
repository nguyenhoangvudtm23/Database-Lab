package DatabaseLab;

public class Ingredient {
	private static int ID = 0;
	private int IngredientID;
	public int getIngredientID() {
		return IngredientID;
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
	
	public Ingredient(String Name, String Description, int AmountLeft) {
		IngredientID = ID++;
		this.Name = Name;
		this.Description = Description;
		this.AmountLeft = AmountLeft;
	}
	public Ingredient(String Name, int AmountLeft) {
		this(Name, "", AmountLeft);
	}
	public Ingredient(String Name) {
		this(Name, "", 0);
	}
	
}
