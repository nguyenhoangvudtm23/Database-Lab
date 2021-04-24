package Application;

import java.sql.SQLException;
import java.time.LocalDateTime;

import Execution.BusinessStatistics;
import Execution.ProductStatistics;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class LineChartController extends ChartControllerUtil{
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
	
}
