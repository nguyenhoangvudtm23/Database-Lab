package Application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Classes.Product;
import Execution.ProductStatistics;
import Query.ProductQuery;
import Scenario.Starter;
import javafx.collections.FXCollections;
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

public class CreateProductController extends MenuController implements Initializable {
	@FXML
	private TextField AmountLeftText, NameText, priceText, DescriptionText;
	private String Name = "", Description = "";
	private double price = 0.0;
	private int AmountLeft = 0;
	
	@FXML Button submitButton, showListProductButton;
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	
	public void CreateProduct(ActionEvent e) throws ClassNotFoundException {
		try {
			AmountLeft = Integer.parseInt((AmountLeftText.getText()));
		}
		catch(Exception error) {
			System.out.println("amount");
		}
		
		try {
			Name = NameText.getText();
		}
		catch(Exception error) {
			System.out.println("name");
		}
		
		try {
			price = Double.parseDouble(priceText.getText());
		}
		catch(Exception error) {
			System.out.println("price");
		}
		try {
			Description = DescriptionText.getText();
		}
		catch(Exception error) {
			System.out.println("description");
		}
		Product newProduct = new Product(AmountLeft, Name, price, Description);
		try {
			Starter.starting();
			ProductStatistics.insertProduct(Name, price, AmountLeft);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(newProduct.getName());
		Configuration.ListProduct.add(newProduct);
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Configuration.ListProduct.clear();
		try {
			Starter.starting();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ResultSet listProd = ProductStatistics.selectAll();
			while (listProd.next())
			{
				//amount_left is 2nd column, name & description are 1st column, price is 3rd column
				Product product = new Product(
						listProd.getInt(2), 
						listProd.getString(1), 
						listProd.getDouble(3),
						listProd.getString(1));
				Configuration.ListProduct.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void showListProduct(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("ShowListProduct.fxml"));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}	
