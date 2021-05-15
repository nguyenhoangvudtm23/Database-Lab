package Classes;

public class Ingredients {

	private int IngredientID;
	private String Name;
	private String description;
	private int Amount_Left;
	public int getIngredientID() {
		return IngredientID;
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
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount_Left() {
		return Amount_Left;
	}
	public void setAmount_Left(int amount_Left) {
		Amount_Left = amount_Left;
	}
	public Ingredients(int ingredientID, String name, String description, int amount_Left) {
		super();
		IngredientID = ingredientID;
		Name = name;
		this.description = description;
		Amount_Left = amount_Left;
	}
	public Ingredients() {
		// TODO Auto-generated constructor stub
	}

}
