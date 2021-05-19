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
	public void back(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
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
