package Application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainMenuController {
	@FXML
	private Label MainMenu;
	@FXML 
	private Button createOrderButton;
	private Stage stage;
	private Parent root;
	private Scene scene;
	public void switchOrderScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("BillScene.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
