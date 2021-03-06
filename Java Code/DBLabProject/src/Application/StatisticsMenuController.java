package Application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import Execution.BusinessStatistics;
import Execution.CustomerStatistics;
import Execution.IngredientStatistics;
import Execution.ProductStatistics;
import Execution.SupplierStatistics;
import Scenario.Starter;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StatisticsMenuController extends MenuController implements Initializable{
	
	private Parent root;
	public static ResultSet resultToDisplay;
	private Scene scene;
	
	public void chooseCustomerScene(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
	{
		Starter.starting();
//		AnchorPane pane = FXMLLoader.load(getClass().getResource("CustomerInput.fxml"));
//		AnchorPane root = (AnchorPane) ((Node)event.getSource()).getParent().getParent().getParent();
//		root.getChildren().setAll(pane);
		root = FXMLLoader.load(getClass().getResource("CustomerInput.fxml"));
		
		scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
	public void chooseRevenueAndCostScene(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
	{
		Starter.starting();
//		AnchorPane pane = FXMLLoader.load(getClass().getResource("RevenueCostInput.fxml"));
//		AnchorPane root = (AnchorPane) ((Node)event.getSource()).getParent().getParent().getParent();
//		root.getChildren().setAll(pane);
//		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		root = (Parent) FXMLLoader.load(getClass().getResource("RevenueCostInput.fxml"));
		scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
	public void chooseSupplierScene(ActionEvent event) throws ClassNotFoundException, SQLException, IOException
	{
		Starter.starting();
		root = FXMLLoader.load(getClass().getResource("SupplierInput.fxml"));
		scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
	public void chooseProductAndIngredientScene(ActionEvent event) throws ClassNotFoundException, SQLException, IOException
	{
		Starter.starting();
		root = FXMLLoader.load(getClass().getResource("ProductIngredientInput.fxml"));
//	stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			Starter.starting();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
