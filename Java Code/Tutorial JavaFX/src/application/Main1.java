package application;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main1 extends Application{

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello World!");
		Button button = new Button();
		button.setText("Say Hello!");
		
		StackPane layout = new StackPane();
		layout.getChildren().addAll(button);
		button.setOnAction(event ->
		{
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setContentText("ARE YOU SURE???");
			alert.setTitle("Confirmation");
			alert.setHeaderText("Hey!");
			ButtonType buttonTypeYes = new ButtonType("YES", ButtonBar.ButtonData.YES);
			ButtonType buttonTypeNo = new ButtonType("NO", ButtonBar.ButtonData.NO);
			ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
			alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo, buttonTypeCancel);
			Optional<ButtonType> result = alert.showAndWait();
			String message = "";
			if (result.get().getButtonData() == ButtonBar.ButtonData.YES)
			{
				//code for yes
				message = "FUCK YOU!";
			}
			if (result.get().getButtonData() == ButtonBar.ButtonData.NO)
			{
				//code for no
				message = "WISE MAN!";
			}
			if (result.get().getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE)
			{
				message = "GOOD";
			}
			
			Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
			alert1.setContentText(message);
			alert1.show();
		});
		Scene scene = new Scene(layout, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
