package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.Group;
public class PieChartController {
	@FXML
	PieChart pieChart;
	public static ObservableList<PieChart.Data> ResultSetWithLegendAndDataToObservableList(ResultSet set) throws SQLException
	{
		ObservableList<PieChart.Data> res = FXCollections.observableArrayList();
		while (set.next())
		{
			res.add(new PieChart.Data(set.getString(1), set.getDouble(1)));
		}
		return res;
	}
	public static ObservableList<PieChart.Data> PairofArrayWithLegendAndDataToObservableList(String[] legend, double[] data)
	{
		ObservableList<PieChart.Data> res = FXCollections.observableArrayList();
		for (int i = 0; i < Math.min(data.length, legend.length); i++)
		{
			res.add(new PieChart.Data(legend[i], data[i]));
		}
		return res;
	}
	public void createAPieChart()
	{
		String[] legend = {"Java",  "C++", "Python"};
		double[] data = {20, 52, 123};
		ObservableList<Data> pieChartData = PieChartController.PairofArrayWithLegendAndDataToObservableList(legend, data);
//		for (int i = 0; i < data.length; i++)
//		{
//			pieChartData.add(new PieChart.Data(legend[i], data[i]));
//		}
		pieChart.getData().clear();
		pieChart.getData().addAll(pieChartData);
	}
}
