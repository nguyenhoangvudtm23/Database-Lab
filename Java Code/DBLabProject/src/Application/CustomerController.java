package Application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import Execution.CustomerStatistics;
import Scenario.Starter;

public class CustomerController extends MenuController implements Initializable{
	@FXML
	BarChart barChart;
	@FXML
	TextField customerNumberBox, dayCustomerBox;
	public void generateChart() throws SQLException
	{
		int days, customerNumber;
		days = 0;
		customerNumber = 0;
		try
		{
			days = Integer.parseInt(dayCustomerBox.getText()); 
			customerNumber = Integer.parseInt(customerNumberBox.getText());
		}
		catch (Exception e) 
		{
			CustomerController.wrongInputType();
		}
		barChart.setTitle("TOP " + customerNumber + " khách hàng chi tiêu nhiều nhất trong " + days + " ngày vừa qua");
		ObservableList<Series> series = BarChartController.convert_Result_Set_To_Bar_Chart_Data
				(CustomerStatistics.getTopXSpendCustomersFromTo(customerNumber, LocalDateTime.now().minusDays(days), LocalDateTime.now()));
		barChart.getData().clear();
		barChart.getXAxis().setAnimated(false);
		barChart.getData().addAll(series);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			Starter.starting();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			showAlert("DB Error", "Can't connect to the database");
			e.printStackTrace();
		}
	}
}
