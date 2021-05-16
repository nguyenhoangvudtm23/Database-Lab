package DatabaseLab;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class CreateProductController implements Initializable {
	@FXML
	private TextField AmountLeftText, NameText, priceText, DescriptionText;
	private String Name = "", Description = "";
	private Double price = 0.0;
	private int AmountLeft = 0;
	
	@FXML Button submitButton, showListProductButton;
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
			price = Double.valueOf(priceText.getText());
		}
		catch(Exception error) {}
		try {
			Description = DescriptionText.getText();
		}
		catch(Exception error) {}
		Product newProduct = new Product(AmountLeft, Name, price, Description);
		Configuration.ListProduct.add(newProduct);
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void showListProduct(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("ShowListProduct.fxml"));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}	