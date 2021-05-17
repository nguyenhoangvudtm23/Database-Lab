package Application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

//Testing purpose only
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		{
			Parent root = FXMLLoader.load(this.getClass().getResource("CreateIngredientScene.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
