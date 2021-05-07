package Application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Execution.BusinessStatistics;
import Execution.CustomerStatistics;
import Execution.ProductStatistics;
import Scenario.Starter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChartChooserController implements Initializable {
	private Stage stage;
	private Parent root;
	public static ResultSet resultToDisplay;
	private Scene scene;
	@FXML
	private VBox vbox;
	@FXML
	private AnchorPane anchorPane;
	
	public void chooseLineChart(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("LineChart.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void chooseBarChart(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("BarChart.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void choosePieChart(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("PieChart.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		
		try {
			Starter.starting();
			resultToDisplay = BusinessStatistics.calculateTotalCostLastXMonths(40);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vbox.setAlignment(Pos.BASELINE_CENTER);
		vbox.prefWidthProperty().bind(anchorPane.widthProperty());
		vbox.prefHeightProperty().bind(anchorPane.heightProperty());
	}
}
