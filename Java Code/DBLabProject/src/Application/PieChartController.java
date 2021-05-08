package Application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Execution.CustomerStatistics;
import Execution.ProductStatistics;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.Group;
public class PieChartController extends ChartControllerUtil implements Initializable {
	@FXML
	PieChart pieChart;
	
	public void createAPieChart() throws SQLException, ClassNotFoundException
	{
		CustomerStatistics.getConnection();
		ObservableList<Data> pieChartData = PieChartController.convert_Result_Set_To_Pie_Chart_Data(CustomerStatistics.sortAllCustomersByTotalSpendDesc(6));
//		for (int i = 0; i < data.length; i++)
//		{
//			pieChartData.add(new PieChart.Data(legend[i], data[i]));
//		}
		pieChart.getData().clear();
		pieChart.getData().addAll(pieChartData);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		vBox.prefWidthProperty().bind(anchorPane.widthProperty());
		vBox.prefHeightProperty().bind(anchorPane.heightProperty());
		vBox.setAlignment(Pos.CENTER);
	}
}
