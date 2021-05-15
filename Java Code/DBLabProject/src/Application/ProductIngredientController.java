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
import Execution.ProductStatistics;
import Scenario.Starter;
public class ProductIngredientController extends MenuController implements Initializable{
	@FXML
	TextField dayBestBox, dayWorstBox, topBestBox, topWorstBox;
	@FXML 
	BarChart barChart;
	public void chooseBestSeller()
	{
		int dayBest, topBest;
		try
		{
			dayBest = Integer.parseInt(dayBestBox.getText());
			topBest = Integer.parseInt(topBestBox.getText());
			barChart.setTitle("TOP " + topBest + " sản phẩm bán chạy nhất trong " + dayBest + " ngày vừa qua");
			ObservableList<Series> series = BarChartController.convert_Result_Set_To_Bar_Chart_Data
					(ProductStatistics.getTopXSellingProductsFromTo(topBest, LocalDateTime.now().minusDays(dayBest), LocalDateTime.now()));
			barChart.getData().clear();
			barChart.getXAxis().setAnimated(false);
			barChart.getData().addAll(series);
		}
		catch (Exception e)
		{
			ProductIngredientController.wrongInputType();
		}
	}
	public void chooseWorstSeller()
	{
		int dayWorst, topWorst;
		try
		{
			dayWorst = Integer.parseInt(dayWorstBox.getText());
			topWorst = Integer.parseInt(topWorstBox.getText());
			barChart.setTitle("TOP " + topWorst + " sản phẩm bán ít nhất trong " + dayWorst + " ngày vừa qua");
			ObservableList<Series> series = BarChartController.convert_Result_Set_To_Bar_Chart_Data
					(ProductStatistics.getLeastXSellingProductsFromTo(topWorst, LocalDateTime.now().minusDays(dayWorst), LocalDateTime.now()));
			barChart.getData().clear();
			barChart.getXAxis().setAnimated(false);
			barChart.getData().addAll(series);
		}
		catch (Exception e)
		{
			ProductIngredientController.wrongInputType();
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			Starter.starting();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
