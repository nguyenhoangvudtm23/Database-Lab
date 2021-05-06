package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PieChart extends Application {
	String[] legend = {"Java",  "C++", "Python"};
	double[] data = {20, 52, 123};
	@Override
	public void start(Stage primaryStage) {
		try
		{
			Parent root = FXMLLoader.load(this.getClass().getResource("PieChart.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
