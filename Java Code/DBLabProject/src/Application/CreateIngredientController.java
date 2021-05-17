package Application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.Ingredient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateIngredientController implements Initializable {

	@FXML
	private TextField AmountLeftText, NameText, PriceText, DescriptionText;
	private String Name = "", Description = "";
	private int AmountLeft = 0;
	private Double Price = 0.0;
	
	@FXML Button submitButton, showListIngredientButton;
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	
	public void CreateProduct(ActionEvent e) {
		try {
			AmountLeft = Integer.valueOf(AmountLeftText.getText());
		}
		catch(Exception error) {
			System.out.println("AmountLeft");
		}
		
		try {
			Name = NameText.getText();
		}
		catch(Exception error) {
			System.out.println("Name");
		}
		
		try {
			Description = DescriptionText.getText();
		}
		catch(Exception error) {
			System.out.println("Description");
		}
		
		try {
			Price = Double.valueOf(PriceText.getText());
		}
		catch(Exception error) {
			System.out.println("Price");
		}
		
		
		Ingredient newIngredient = new Ingredient(Name, Price, Description, AmountLeft);
		Configuration.ListIngredient.add(newIngredient);
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void showListIngredient(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("ShowListIngredient.fxml"));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
