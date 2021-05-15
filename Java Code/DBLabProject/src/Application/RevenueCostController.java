package Application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Execution.BusinessStatistics;
import Scenario.Starter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class RevenueCostController extends MenuController implements Initializable{
	@FXML
	TextField dayRevenueBox;
	@FXML
	TextField dayCostBox;
	@FXML
	TextField weekRevenueBox;
	@FXML
	TextField weekCostBox;
	@FXML 
	TextField monthRevenueBox;
	@FXML
	TextField monthCostBox;
	@FXML
	TextField yearRevenueBox;
	@FXML
	TextField yearCostBox;
	
	public void toChartChooserScene(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("ChartChooser.fxml"));
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void wrongInputType()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Sai định dạng!");
		alert.setContentText("Nhập vào một số nguyên");
		alert.showAndWait();
	}
	public void chooseMonthRevenue(ActionEvent event)
	{
		try {
			int months = Integer.parseInt(monthRevenueBox.getText());
			ChartChooserController.chartName = "Doanh thu " + months + " tháng gần nhất";
			ChartChooserController.resultToDisplay = BusinessStatistics.calculateTotalRevenueLastXMonths(months);
			toChartChooserScene(event);
		}
		catch(Exception e)
		{
			wrongInputType();
		}
	}
	public void chooseMonthCost(ActionEvent event)
	{
		try {
			int months = Integer.parseInt(monthCostBox.getText());
			ChartChooserController.chartName = "Chi phí " + months + " tháng gần nhất";
			ChartChooserController.resultToDisplay = BusinessStatistics.calculateTotalCostLastXMonths(months);
			toChartChooserScene(event);
		}
		catch(Exception e)
		{
			wrongInputType();
		}
	}
	public void chooseWeekRevenue(ActionEvent event)
	{
		try {
			int weeks = Integer.parseInt(weekRevenueBox.getText());
			ChartChooserController.chartName = "Doanh thu " + weeks + " tuần gần nhất";
			ChartChooserController.resultToDisplay = BusinessStatistics.calculateTotalRevenueLastXWeeks(weeks);
			toChartChooserScene(event);
		}
		catch(Exception e)
		{
			wrongInputType();
		}
	}
	public void chooseWeekCost(ActionEvent event)
	{
		try {
			int weeks = Integer.parseInt(weekCostBox.getText());
			ChartChooserController.chartName = "Chi phí " + weeks + " tuần gần nhất";
			ChartChooserController.resultToDisplay = BusinessStatistics.calculateTotalCostLastXWeeks(weeks);
			toChartChooserScene(event);
		}
		catch(Exception e)
		{
			wrongInputType();
		}
	}
	public void chooseDayRevenue(ActionEvent event)
	{
		try {
			int days = Integer.parseInt(dayRevenueBox.getText());
			ChartChooserController.chartName = "Chi phí " + days + " ngày gần nhất";
			ChartChooserController.resultToDisplay = BusinessStatistics.calculateTotalRevenueLastXDays(days);
			toChartChooserScene(event);
		}
		catch(Exception e)
		{
			wrongInputType();
		}
	}
	public void chooseDayCost(ActionEvent event)
	{
		try {
			int days = Integer.parseInt(dayCostBox.getText());
			ChartChooserController.chartName = "Chi phí " + days + " ngày gần nhất";
			ChartChooserController.resultToDisplay = BusinessStatistics.calculateTotalCostLastXDays(days);
			toChartChooserScene(event);
		}
		catch(Exception e)
		{
			wrongInputType();
		}
	}
	public void chooseYearRevenue(ActionEvent event)
	{
		try {
			int years = Integer.parseInt(yearRevenueBox.getText());
			ChartChooserController.chartName = "Doanh thu " + years + " năm gần nhất";
			ChartChooserController.resultToDisplay = BusinessStatistics.calculateTotalRevenueLastXYears(years);
			toChartChooserScene(event);
		}
		catch(Exception e)
		{
			wrongInputType();
		}
	}
	public void chooseYearCost(ActionEvent event)
	{
		try {
			int years = Integer.parseInt(yearCostBox.getText());
			ChartChooserController.chartName = "Chi phí " + years + " năm gần nhất";
			ChartChooserController.resultToDisplay = BusinessStatistics.calculateTotalCostLastXYears(years);
			toChartChooserScene(event);
		}
		catch(Exception e)
		{
			wrongInputType();
		}
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
			e.printStackTrace();
		}
	}
}
