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

public class ManagementMenuController extends MenuController implements Initializable{
	private Stage stage;
	private Parent root;
	private Scene scene;
	public void switchIngredientScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("CreateIngredientScene.fxml"));
		stage = new Stage();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchProductScene(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("CreateProductScene.fxml"));
		stage = new Stage();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchSupplierScene(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("ShowListSupplier.fxml"));
		stage = new Stage();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchCustomerScene(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("ShowListCustomer.fxml"));
		stage = new Stage();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchOrderScene(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("ShowListOrder.fxml"));
		stage = new Stage();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchBuyOrderScene(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("ShowListBuyOrder.fxml"));
		stage = new Stage();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}
