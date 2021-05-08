package Application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import Execution.BusinessStatistics;
import Execution.ProductStatistics;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BarChartController extends ChartControllerUtil implements ChartController, Initializable{
	@FXML
	BarChart barChart;
	@FXML
	Button createChart;
	
	public void createABarChart() throws SQLException, ClassNotFoundException
	{
		//BusinessStatistics.getConnection();
		barChart.setTitle(ChartChooserController.chartName);
		ObservableList<Series> series = BarChartController.convert_Result_Set_To_Bar_Chart_Data
				(ChartChooserController.resultToDisplay);
		//barChart.getData().clear();
		//loi ngu ngoc voi truc X cac ban a dcm nha no
		barChart.getXAxis().setAnimated(false);
		barChart.getData().addAll(series);
	}
	public void clear()
	{
		barChart.getData().clear();
	}
	public void back(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(this.getClass().getResource("StatisticsMenu.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();;
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		barChart.setTitle(ChartChooserController.chartName);
		vBox.prefWidthProperty().bind(anchorPane.widthProperty());
		vBox.prefHeightProperty().bind(anchorPane.heightProperty());
		vBox.setAlignment(Pos.CENTER);
	}
}
