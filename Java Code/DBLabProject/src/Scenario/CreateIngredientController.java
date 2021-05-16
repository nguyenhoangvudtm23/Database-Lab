package DatabaseLab;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateIngredientController implements Initializable {

	@FXML
	private TextField AmountLeftText, NameText, priceText, DescriptionText;
	private String Name = "", Description = "";
	private int AmountLeft = 0;
	
	@FXML Button submitButton;
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	
	public void CreateProduct(ActionEvent e) {
		try {
			AmountLeft = Integer.valueOf(AmountLeftText.getText());
		}
		catch(Exception error) {}
		
		try {
			Name = NameText.getText();
		}
		catch(Exception error) {}
		
		try {
			Description = DescriptionText.getText();
		}
		catch(Exception error) {}
		Ingredient newIngredient = new Ingredient(Name, Description, AmountLeft);
		Configuration.ListIngredient.add(newIngredient);
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
