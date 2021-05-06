package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main4 extends Application {

	@Override
	public void start(Stage primaryStage) {
		Label label = new Label("Gender");
		CheckBox box1 = new CheckBox("Male");
		CheckBox box2 = new CheckBox("Female");
		box1.setSelected(true);
		Button button = new Button("Submit");
		button.setOnAction(event ->
		{
			String message = "Your gender: ";
			if (box1.isSelected())
			{
				message += box1.getText();
			}
			else
			{
				message += box2.getText();
			}
			System.out.println(message);
		});
		HBox layoutH = new HBox(10);
		layoutH.getChildren().addAll(box1, box2);
		VBox layoutV = new VBox(10);
		layoutV.getChildren().addAll(label, layoutH, button);
		Scene scene = new Scene(layoutV, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}

	public static void main(String[] args) {
		launch(args);
	}
}
