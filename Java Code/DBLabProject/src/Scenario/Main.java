package DatabaseLab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		launch(args);
	}

	@Override
	public void start(Stage Stage) throws Exception {
		// TODO Auto-generated method stub
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CreateIngredientScene.fxml"));
			Scene scene = new Scene(root);
			Stage.setScene(scene);
			Stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
