package Application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public abstract class MenuController {
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
	public void switchOrderScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("BillScene.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchStatisticsScene(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("StatisticsMenu.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchManagementScene(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("ManagementMenu.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public static void wrongInputType()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Sai định dạng!");
		alert.setContentText("Nhập vào một số nguyên");
		alert.showAndWait();
	}
	public void toChartChooserScene(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("ChartChooser.fxml"));
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
