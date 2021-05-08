package Application;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.NumberExpression;
import javafx.beans.value.ObservableNumberValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BarChart extends Application {
	static ObservableNumberValue op1;
	static ObservableNumberValue op2;
	
	@Override
	public void start(Stage primaryStage) {
		try
		{
			Parent root = FXMLLoader.load(this.getClass().getResource("BarChart.fxml"));
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
