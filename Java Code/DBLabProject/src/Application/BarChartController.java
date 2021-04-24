package Application;

import java.sql.SQLException;
import java.time.LocalDateTime;

import Execution.BusinessStatistics;
import Execution.ProductStatistics;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class BarChartController extends ChartControllerUtil {
	@FXML
	BarChart barChart;
	public void createABarChart() throws SQLException, ClassNotFoundException
	{
		BusinessStatistics.getConnection();
		ObservableList<Series> series = BarChartController.convert_Result_Set_To_Bar_Chart_Data
				(BusinessStatistics.calculateTotalCostLastXMonths(40));
		//barChart.getData().clear();
		barChart.setTitle("This is a bar chart");
		//loi ngu ngoc voi truc X cac ban a dcm nha no
		barChart.getXAxis().setAnimated(false);
		barChart.getData().addAll(series);
	}
	public void clear()
	{
		barChart.getData().clear();
	}
}
