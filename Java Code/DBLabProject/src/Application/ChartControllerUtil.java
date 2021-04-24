package Application;

import java.sql.ResultSet;

import java.sql.SQLException;
import javafx.scene.chart.BarChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class ChartControllerUtil {
	//All of the following implementations are for <String, Double> pairs
	//ResultSet must return two columns with Name as the 1st column - Value as the 2nd column 
	public static ObservableList<PieChart.Data> convert_Result_Set_To_Pie_Chart_Data(ResultSet set) throws SQLException
	{
		ObservableList<PieChart.Data> res = FXCollections.observableArrayList();
		while (set.next())
		{
			res.add(new PieChart.Data(set.getString(1), set.getDouble(2)));
		}
		return res;
	}
	public static ObservableList<PieChart.Data> convert_Pair_of_Arrays_To_Pie_Chart_Data(String[] legend, double[] data)
	{
		ObservableList<PieChart.Data> res = FXCollections.observableArrayList();
		for (int i = 0; i < Math.min(data.length, legend.length); i++)
		{
			res.add(new PieChart.Data(legend[i], data[i]));
		}
		return res;
	}
	public static XYChart.Series convert_Result_Set_To_Line_Chart_Data(ResultSet set) throws SQLException
	{
		XYChart.Series res = new XYChart.Series();
		while (set.next())
		{
			XYChart.Data<String, Double> data = new XYChart.Data(set.getString(1), set.getDouble(2));
			res.getData().add(data);
		}
		return res;
	}
	public static XYChart.Series convert_Pair_of_Arrays_To_Line_Chart_Data(String[] legend, double[] data) 
	{
		XYChart.Series res = new XYChart.Series();
		for (int i = 0; i < Math.min(data.length, legend.length); i++)
		{
			XYChart.Data<String, Double> tobeadded = new XYChart.Data(legend[i], data[i]);
			res.getData().add(tobeadded);
		}
		return res;
	}
	public static ObservableList<XYChart.Series> convert_Result_Set_To_Bar_Chart_Data(ResultSet set) throws SQLException
	{
		ObservableList<XYChart.Series> res = FXCollections.observableArrayList();
		while (set.next())
		{
			XYChart.Series tmp = new XYChart.Series();
			tmp.setName(set.getString(1));
			tmp.getData().add(new XYChart.Data("", set.getDouble(2)));
			res.add(tmp);
		}
		return res;
	}
	public static XYChart.Series<String, Double> convert_Pair_of_Arrays_To_Bar_Chart_Data(String[] legend, double[] data)
	{
		XYChart.Series<String, Double> res = new XYChart.Series<String, Double>();
		for (int i = 0; i < Math.min(data.length, legend.length); i++)
		{
			res.getData().add(new XYChart.Data(legend[i], data[i]));
		}
		return res;
	}
	
}
