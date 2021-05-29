package Application;

import java.io.IOException;
import java.sql.SQLException;

import Scenario.Starter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract class MenuController {
	@FXML
	private AnchorPane rootPane;
	private Stage stage;
	private Parent root;
	private Scene scene;
	public void back(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root); 
		stage.setScene(scene);
		stage.show();
	}
	public void chooseLineChart(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("LineChart.fxml"));
		
		rootPane.getChildren().setAll(pane);
//		root = FXMLLoader.load(getClass().getResource("LineChart.fxml"));
//		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
	}
	public void chooseBarChart(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("BarChart.fxml"));
		
		rootPane.getChildren().setAll(pane);
//		root = FXMLLoader.load(getClass().getResource("BarChart.fxml"));
//		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
	}
	public void choosePieChart(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("PieChart.fxml"));
		
		rootPane.getChildren().setAll(pane);
//		root = FXMLLoader.load(getClass().getResource("PieChart.fxml"));
//		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
	}
	public void switchOrderScene(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("BillScene.fxml"));
		
		rootPane.getChildren().setAll(pane);
//		Parent root = FXMLLoader.load(getClass().getResource("BillScene.fxml"));
//		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
	}
	public void switchBuyOrderScene(ActionEvent event) throws IOException
	{
		AnchorPane pane = FXMLLoader.load(getClass().getResource("BuyOrder.fxml"));
		rootPane.getChildren().setAll(pane);
//		Parent root = FXMLLoader.load(getClass().getResource("BuyOrder.fxml"));
//		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
	}
	public void switchStatisticsScene(ActionEvent event) throws IOException
	{
		AnchorPane pane = FXMLLoader.load(getClass().getResource("StatisticsMenu.fxml"));
		rootPane.getChildren().setAll(pane);
//		Parent root = FXMLLoader.load(getClass().getResource("StatisticsMenu.fxml"));
//		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show(); 
	}
	public void switchManagementScene(ActionEvent event) throws IOException
	{
		AnchorPane pane = FXMLLoader.load(getClass().getResource("ManagementMenu.fxml"));
		rootPane.getChildren().setAll(pane);
//		Parent root = FXMLLoader.load(getClass().getResource("ManagementMenu.fxml"));
//		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
	}
	public static void wrongInputType()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Sai định dạng!");
		alert.setContentText("Nhập vào một số nguyên");
		alert.showAndWait();
	}
	public static void showAlert(String header, String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(header);
		alert.setContentText(message);
		alert.showAndWait();
	}
	public void toChartChooserScene(ActionEvent event) throws IOException
	{
		AnchorPane pane = FXMLLoader.load(getClass().getResource("ChartChooser.fxml"));
		rootPane.getChildren().setAll(pane);
//		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//		Scene scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
	}
	
}
