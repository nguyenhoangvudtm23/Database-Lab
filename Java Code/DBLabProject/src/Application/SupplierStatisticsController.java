package Application;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import Execution.CustomerStatistics;
import Execution.SupplierStatistics;
import Scenario.Starter;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TextField;

public class SupplierStatisticsController extends MenuController implements Initializable{
	@FXML
	BarChart barChart;
	@FXML
	TextField supplierNumberBox, daySupplierBox;
	public void createChart() throws SQLException
	{
		int days, suppliers;
		days = 0;
		suppliers = 0;
		try {
			days = Integer.valueOf(daySupplierBox.getText());
			suppliers = Integer.valueOf(supplierNumberBox.getText());
			//barChart.setVisible(true);
		}
		catch (Exception e){
			wrongInputType();
		}
		barChart.setTitle("TOP " + suppliers + " nhà cung cấp nhập về nhiều nhất trong " + days + " ngày vừa qua");
		ObservableList<Series> series = BarChartController.convert_Result_Set_To_Bar_Chart_Data
				(SupplierStatistics.topXbestsuppliersYdays(suppliers, days));
		barChart.getData().clear();
		barChart.getXAxis().setAnimated(false);
		barChart.getData().addAll(series);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//barChart.setVisible(false);
		try {
			Starter.starting();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
