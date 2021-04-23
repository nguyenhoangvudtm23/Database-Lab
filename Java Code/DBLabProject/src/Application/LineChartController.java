package Application;

import java.sql.SQLException;
import java.time.LocalDateTime;

import Execution.ProductStatistics;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class LineChartController extends ChartControllerUtil{
	@FXML
	LineChart lineChart;
	public void createALineChart() throws SQLException, ClassNotFoundException
	{
		ProductStatistics.getConnection();
		XYChart.Series<String, Double> series = LineChartController.convert_Result_Set_To_Line_Or_Bar_Chart_Data
				(ProductStatistics.calculateAllProductRevenueFromTo(LocalDateTime.MIN, LocalDateTime.MAX));
		lineChart.getData().clear();
		lineChart.getData().add(series);
	}
	
}
