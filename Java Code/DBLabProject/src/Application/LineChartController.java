package Application;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import Execution.BusinessStatistics;
import Execution.ProductStatistics;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class LineChartController extends ChartControllerUtil implements ChartController, Initializable{
	@FXML
	LineChart<String, Number> lineChart;
	public void createALineChart() throws SQLException, ClassNotFoundException
	{
		BusinessStatistics.getConnection();
		Series series = LineChartController.convert_Result_Set_To_Line_Chart_Data
				(BusinessStatistics.calculateTotalCostLastXMonths(120));
		//lineChart.getData().clear();
		//javaFX has a bug with chart, noi chung la loi nay no ngu vcl the luon
		lineChart.getXAxis().setAnimated(false);;
		lineChart.getData().addAll(series);
		
	}
	public void clear() 
	{
		lineChart.getData().clear();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		vBox.prefWidthProperty().bind(anchorPane.widthProperty());
		vBox.prefHeightProperty().bind(anchorPane.heightProperty());
		vBox.setAlignment(Pos.CENTER);
	}
	
}
