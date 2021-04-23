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
	//Two-column tables only
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
	public static XYChart.Series<String, Double> convert_Result_Set_To_Line_Or_Bar_Chart_Data(ResultSet set) throws SQLException
	{
		XYChart.Series<String, Double> res = new XYChart.Series<String, Double>();
		while (set.next())
		{
			res.getData().addAll(new XYChart.Data(set.getString(1), set.getDouble(2)));
		}
		return res;
	}
	public static XYChart.Series<String, Double> convert_Pair_of_Arrays_To_Line_Or_Bar_Chart_Data(String[] legend, double[] data)
	{
		XYChart.Series<String, Double> res = new XYChart.Series<String, Double>();
		for (int i = 0; i < Math.min(data.length, legend.length); i++)
		{
			res.getData().add(new XYChart.Data(legend[i], data[i]));
		}
		return res;
	}
	
}
