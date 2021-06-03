package Application;
	
import java.io.IOException;
import java.sql.SQLException;

import Scenario.Starter;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

//Testing purpose only
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		{
			SceneHolder.getSingleton().setup();
			Parent root = FXMLLoader.load(this.getClass().getResource("SplashScreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene); 
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
			FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), root);
			fadeIn.setFromValue(0);
			fadeIn.setToValue(1);
			fadeIn.setCycleCount(1);
			
			FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), root);
			fadeOut.setFromValue(1);
			fadeOut.setToValue(0);
			fadeOut.setCycleCount(1);
			
			fadeIn.play();
			fadeIn.setOnFinished(e -> {
				try {
					Starter.starting();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fadeOut.play();
			});
			
			fadeOut.setOnFinished(e -> {
				try {
					primaryStage.close();
					launch();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		}
		
	}
	public void launch() throws IOException
	{
		Parent root = SceneHolder.getMainMenu();
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene); 
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
