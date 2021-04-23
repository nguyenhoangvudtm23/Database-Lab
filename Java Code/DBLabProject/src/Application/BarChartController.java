package Application;

import java.sql.SQLException;
import java.time.LocalDateTime;

import Execution.ProductStatistics;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class BarChartController extends ChartControllerUtil {
	@FXML
	BarChart barChart;
	public void createABarChart() throws SQLException, ClassNotFoundException
	{
		ProductStatistics.getConnection();
		XYChart.Series<String, Double> series = BarChartController.convert_Result_Set_To_Line_Or_Bar_Chart_Data
				(ProductStatistics.calculateAllProductRevenueFromTo(LocalDateTime.MIN, LocalDateTime.MAX));
		barChart.getData().clear();
		barChart.getData().add(series);
	}
}
