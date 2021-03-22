package application;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.Stage;

public class Main2 extends Application {
	Stage window;
	Scene scene1, scene2;
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		//scene1
		Label label = new Label("HELLO");
		Button button1 = new Button("Say hello");
		button1.setOnAction(new EventHandler<ActionEvent>() 
				{
					
					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						window.setScene(scene2);
					}
				});
		VBox layout1 = new VBox();
		layout1.getChildren().addAll(label, button1);
		scene1 = new Scene(layout1, 400, 300);
		
		//scene2
		Button button2 = new Button("Go back");
		button2.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						window.setScene(scene1);
					}
				});
		StackPane layout2 = new StackPane();
		layout2.getChildren().addAll(button2);
		scene2 = new Scene(layout2, 400, 300);
		
		window.setScene(scene1);
		window.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
