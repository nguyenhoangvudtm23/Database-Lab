package Application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenuController extends MenuController implements Initializable{
	@FXML
	private Label MainMenu;
	@FXML
	private AnchorPane textPane;
	@FXML
	private AnchorPane iconPane;
	@FXML 
	private Button createOrderButton;
	@FXML
	private Button statisticsButton;
	@FXML
	private JFXButton navigateButton;
	@FXML
	private JFXButton exitButton;
	@FXML
	private Button managementButton;
	public void minimize()
	{
		Stage stage = (Stage) textPane.getScene().getWindow();
		stage.setIconified(true);
	}
	public void maximize()
	{
		Stage stage = (Stage) textPane.getScene().getWindow();
		if (!stage.isMaximized())
		{
			stage.setMaximized(true);
		}
		else
		{
			stage.setMaximized(false);
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		exitButton.setOnAction(event -> {
			System.exit(0);
		});
		textPane.setVisible(false);
		
		FadeTransition fade = new FadeTransition(Duration.seconds(0.5), textPane);
		
		
		navigateButton.setOnMouseClicked(event -> {
			textPane.setVisible(true);
			rootPane.toBack();
			fade.setFromValue(0);
			fade.setToValue(1);
			fade.setOnFinished(e -> {
				textPane.toFront();
			});
			fade.play();
		});
		rootPane.setOnMouseClicked(event -> {
			if (textPane.isVisible())
			{
				fade.setFromValue(1);
				fade.setToValue(0);
				fade.setOnFinished(e ->
				{
					//rootPane.toFront();
					textPane.setVisible(false);
					textPane.toBack();
					
				});
				fade.play();
				
			}
		});
	}

}
